package simpledb;

import java.io.*;
import java.util.*;
import java.io.RandomAccessFile;

/**
 * HeapFile is an implementation of a DbFile that stores a collection of tuples
 * in no particular order. Tuples are stored on pages, each of which is a fixed
 * size, and the file is simply a collection of those pages. HeapFile works
 * closely with HeapPage. The format of HeapPages is described in the HeapPage
 * constructor.
 * 
 * @see simpledb.HeapPage#HeapPage
 * @author Sam Madden
 */
public class HeapFile implements DbFile {
	private File file;
	private int numpage;
	private TupleDesc tupledesc;

    /**
     * Constructs a heap file backed by the specified file.
     * 
     * @param f
     *            the file that stores the on-disk backing store for this heap
     *            file.
     */
    public HeapFile(File f, TupleDesc td) {
        // some code goes here
    	this.file=f;
    	//计算页数，文件总长度除以缓冲池的最大容纳量
    	numpage=(int)(file.length()/BufferPool.PAGE_SIZE);
    	this.tupledesc=td;
    }

    /**
     * Returns the File backing this HeapFile on disk.
     * 
     * @return the File backing this HeapFile on disk.
     */
    public File getFile() {
        // some code goes here
        return this.file;
    }

    /**
     * Returns an ID uniquely identifying this HeapFile. Implementation note:
     * you will need to generate this tableid somewhere ensure that each
     * HeapFile has a "unique id," and that you always return the same value for
     * a particular HeapFile. We suggest hashing the absolute file name of the
     * file underlying the heapfile, i.e. f.getAbsoluteFile().hashCode().
     * 
     * @return an ID uniquely identifying this HeapFile.
     */
    public int getId() {
        // some code goes here
        return file.getAbsoluteFile().hashCode();
    }

    /**
     * Returns the TupleDesc of the table stored in this DbFile.
     * 
     * @return TupleDesc of this DbFile.
     */
    public TupleDesc getTupleDesc() {
        // some code goes here
       return this.tupledesc;
    }

    // see DbFile.java for javadocs
    /**
     * 根据PageId从磁盘读取一个页，注意此方法只应该在BufferPool类被直接调用
     * 在其他需要page的地方需要通过BufferPool访问。这样才能实现缓存功能
     *
     * @param pid
     * @return 读取得到的Page
     * @throws IllegalArgumentException
     */
    public Page readPage(PageId pid)throws IllegalArgumentException {
        // some code goes here
        Page page=null;
        byte[]data=new byte[BufferPool.PAGE_SIZE];
        //随机位置都可以进行读写
        try(RandomAccessFile raf=new RandomAccessFile(getFile(),"r"))
        {
        	//读写操作的位置,page在HeapFile的偏移量
        	int pos=pid.pageNumber()*BufferPool.PAGE_SIZE;
        	//从pos处开始读
        	raf.seek(pos);
        	//存放在data字节数组内，存0号位，共读length个长度
        	raf.read(data,0,data.length);
        	page=new HeapPage((HeapPageId)pid,data);
        }
        catch(IOException e)
        {
        	e.printStackTrace();
        }
        return page;
    }

    // see DbFile.java for javadocs
    public void writePage(Page page) throws IOException {
        // some code goes here
        // not necessary for lab1
    }

    /**
     * Returns the number of pages in this HeapFile.
     */
    public int numPages() {
        // some code goes here
        return this.numpage;
    }

    // see DbFile.java for javadocs
    public ArrayList<Page> insertTuple(TransactionId tid, Tuple t)
            throws DbException, IOException, TransactionAbortedException {
        // some code goes here
        return null;
        // not necessary for lab1
    }

    // see DbFile.java for javadocs
    public ArrayList<Page> deleteTuple(TransactionId tid, Tuple t) throws DbException,
            TransactionAbortedException {
        // some code goes here
        return null;
        // not necessary for lab1
    }

    // see DbFile.java for javadocs
    public DbFileIterator iterator(TransactionId tid) {
        // some code goes here
        return new HeapFileIterator(tid);
    }
    
    
    private class HeapFileIterator implements DbFileIterator
    {
    	 private int pagePos;
         private Iterator<Tuple> tuplesInPage;
         private TransactionId tid;

         public HeapFileIterator(TransactionId tid) {
             this.tid = tid;
         }
         
         public Iterator<Tuple> getTuplesInPage(HeapPageId pid)throws TransactionAbortedException, DbException
         {
        	 //必须要通过BufferPool来获得page
        	 HeapPage page=(HeapPage)Database.getBufferPool().getPage(tid, pid,  Permissions.READ_ONLY);
        	 return page.iterator();
         }
         

		@Override
		public void open() throws DbException, TransactionAbortedException {
			// TODO Auto-generated method stub
			pagePos=0;
			HeapPageId pid=new HeapPageId(getId(),pagePos);
			//调用上一个函数，第一页的tuples
			tuplesInPage=getTuplesInPage(pid);
		}

		@Override
		public boolean hasNext() throws DbException, TransactionAbortedException {
			// TODO Auto-generated method stub
			//已关闭
			if(tuplesInPage==null)return false;
			//当前页还有tuple未遍历
			else if(tuplesInPage.hasNext())return true;
			//下一页是否还有要遍历的,HeapFile中的页面编号为0,1，... numPages（） - 1
			else if(pagePos<numPages()-1)
			{
				pagePos++;
				HeapPageId pid=new HeapPageId(getId(),pagePos);
				tuplesInPage=getTuplesInPage(pid);
				return tuplesInPage.hasNext();
			}
			else
				return false;
		}

		@Override
		public Tuple next() throws DbException, TransactionAbortedException, NoSuchElementException {
			// TODO Auto-generated method stub
		    if(!hasNext())
		    {
		    	throw new NoSuchElementException("已全部关闭或者没有tuple剩余！");
		    }
		    return tuplesInPage.next();
		}

		@Override
		public void rewind() throws DbException, TransactionAbortedException {
			// TODO Auto-generated method stub
			//重新初始化
			open();
		}

		@Override
		public void close() {
			// TODO Auto-generated method stub
			pagePos=0;
			tuplesInPage=null;
		}
    	
    }

}

