package simpledb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


//哈希表类似字典
/**
 * The Catalog keeps track of all available tables in the database and their
 * associated schemas.
 * For now, this is a stub catalog that must be populated with tables by a
 * user program before it can be used -- eventually, this should be converted
 * to a catalog that reads a catalog table from disk.
 * 
 * @Threadsafe
 */
public class Catalog {

    /**
     * Constructor.
     * Creates a new, empty catalog.
     */
	//Integer是整型数/整数
	//Map是一个键值对对象-----字典
	//建立tableid到DbFiles的映射
	private HashMap<Integer,DbFile> idFile;
	//建立tableid到表的主键的映射
	private HashMap<Integer,String>idPrkey;
	//建立tableid到表的名称的映射
	private HashMap<Integer,String>idName;
	//建立表的名称到tableid的映射
	private HashMap<String,Integer>nameId;
	
    public Catalog() {
        // some code goes here
    	idFile=new HashMap<>();
    	idPrkey=new HashMap<>();
    	idName=new HashMap<>();
    	nameId=new HashMap<>();
    }

    /**
     * Add a new table to the catalog.
     * This table's contents are stored in the specified DbFile.
     * @param file the contents of the table to add;  file.getId() is the identfier of
     *    this file/tupledesc param for the calls getTupleDesc and getFile
     * @param name the name of the table -- may be an empty string.  May not be null.  If a name
     * conflict exists, use the last table to be added as the table for a given name.
     * @param pkeyField the name of the primary key field
     */
    public void addTable(DbFile file, String name, String pkeyField) {
        // some code goes here
    	if(name==null||pkeyField==null)
    		throw new IllegalArgumentException();
    	int tableid=file.getId();
    	//处理表名冲突 ContainsKey(object key)是否包含指定的键
    	if(nameId.containsKey(name))
    	{
    		throw new UnsupportedOperationException("不支持添加相同名字的table");
    	}
    	//在哈希表中添加内容
    	idFile.put(tableid,file);
    	idName.put(tableid,name);
    	idPrkey.put(tableid,pkeyField);
    	nameId.put(name,tableid);
    }

    public void addTable(DbFile file, String name) {
    	//调用上一个函数（函数的多态性）
        addTable(file, name, "");
    }

    /**
     * Add a new table to the catalog.
     * This table has tuples formatted using the specified TupleDesc and its
     * contents are stored in the specified DbFile.
     * @param file the contents of the table to add;  file.getId() is the identfier of
     *    this file/tupledesc param for the calls getTupleDesc and getFile
     */
    public void addTable(DbFile file) {
        addTable(file, (UUID.randomUUID()).toString());
    }

    /**
     * Return the id of the table with a specified name,
     * @throws NoSuchElementException if the table doesn't exist
     */
    public int getTableId(String name) throws NoSuchElementException {
        // some code goes here
    	//如果没有给name的变量或者在名为nameid的哈希表内没有名为name的数据
    	if(name==null||!nameId.containsKey(name))
    		throw new NoSuchElementException();
    	//获取哈希表关键名为name的值
        return nameId.get(name);
    }

    /**
     * Returns the tuple descriptor (schema) of the specified table
     * @param tableid The id of the table, as specified by the DbFile.getId()
     *     function passed to addTable
     * @throws NoSuchElementException if the table doesn't exist
     */
    public TupleDesc getTupleDesc(int tableid) throws NoSuchElementException {
        // some code goes here
    	if(!isValid(tableid,idFile)||!idFile.containsKey(tableid))
    		throw new NoSuchElementException();
        return idFile.get(tableid).getTupleDesc();
    }

    /**
     * Returns the DbFile that can be used to read the contents of the
     * specified table.
     * @param tableid The id of the table, as specified by the DbFile.getId()
     *     function passed to addTable
     */
    private boolean isValid(int id, HashMap<?, ?> map) {
        return map.containsKey(id);
    }
    
    public DbFile getDatabaseFile(int tableid) throws NoSuchElementException {
        // some code goes here
    	if(!isValid(tableid,idFile))
    		throw new NoSuchElementException();
    	return idFile.get(tableid);
    }

    public String getPrimaryKey(int tableid) {
        // some code goes here
        if(!isValid(tableid,idPrkey))
        	throw new NoSuchElementException();
        return idPrkey.get(tableid);
    }

    public Iterator<Integer> tableIdIterator() {
        // some code goes here
       return idName.keySet().iterator();
    }

    public String getTableName(int id) {
        // some code goes here
    	if(!isValid(id,idName))
        	throw new NoSuchElementException();
        return idName.get(id);
    }
    
    /** Delete all tables from the catalog */
    public void clear() {
        // some code goes here
    	//清除哈希表
    	idName.clear();
    	idPrkey.clear();
    	idFile.clear();
    	nameId.clear();
    }
    
    /**
     * Reads the schema from a file and creates the appropriate tables in the database.
     * @param catalogFile
     */
    public void loadSchema(String catalogFile) {
        String line = "";
        String baseFolder=new File(new File(catalogFile).getAbsolutePath()).getParent();
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(catalogFile)));
            
            while ((line = br.readLine()) != null) {
                //assume line is of the format name (field type, field type, ...)
                String name = line.substring(0, line.indexOf("(")).trim();
                //System.out.println("TABLE NAME: " + name);
                String fields = line.substring(line.indexOf("(") + 1, line.indexOf(")")).trim();
                String[] els = fields.split(",");
                ArrayList<String> names = new ArrayList<String>();
                ArrayList<Type> types = new ArrayList<Type>();
                String primaryKey = "";
                for (String e : els) {
                    String[] els2 = e.trim().split(" ");
                    names.add(els2[0].trim());
                    if (els2[1].trim().toLowerCase().equals("int"))
                        types.add(Type.INT_TYPE);
                    else if (els2[1].trim().toLowerCase().equals("string"))
                        types.add(Type.STRING_TYPE);
                    else {
                        System.out.println("Unknown type " + els2[1]);
                        System.exit(0);
                    }
                    if (els2.length == 3) {
                        if (els2[2].trim().equals("pk"))
                            primaryKey = els2[0].trim();
                        else {
                            System.out.println("Unknown annotation " + els2[2]);
                            System.exit(0);
                        }
                    }
                }
                Type[] typeAr = types.toArray(new Type[0]);
                String[] namesAr = names.toArray(new String[0]);
                TupleDesc t = new TupleDesc(typeAr, namesAr);
                HeapFile tabHf = new HeapFile(new File(baseFolder+"/"+name + ".dat"), t);
                addTable(tabHf,name,primaryKey);
                System.out.println("Added table : " + name + " with schema " + t);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        } catch (IndexOutOfBoundsException e) {
            System.out.println ("Invalid catalog entry : " + line);
            System.exit(0);
        }
    }
}

