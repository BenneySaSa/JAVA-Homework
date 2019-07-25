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
    	//����ҳ�����ļ��ܳ��ȳ��Ի���ص����������
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
     * ����PageId�Ӵ��̶�ȡһ��ҳ��ע��˷���ֻӦ����BufferPool�౻ֱ�ӵ���
     * ��������Ҫpage�ĵط���Ҫͨ��BufferPool���ʡ���������ʵ�ֻ��湦��
     *
     * @param pid
     * @return ��ȡ�õ���Page
     * @throws IllegalArgumentException
     */
    public Page readPage(PageId pid)throws IllegalArgumentException {
        // some code goes here
        Page page=null;
        byte[]data=new byte[BufferPool.PAGE_SIZE];
        //���λ�ö����Խ��ж�д
        try(RandomAccessFile raf=new RandomAccessFile(getFile(),"r"))
        {
        	//��д������λ��,page��HeapFile��ƫ����
        	int pos=pid.pageNumber()*BufferPool.PAGE_SIZE;
        	//��pos����ʼ��
        	raf.seek(pos);
        	//�����data�ֽ������ڣ���0��λ������length������
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
        	 //����Ҫͨ��BufferPool�����page
        	 HeapPage page=(HeapPage)Database.getBufferPool().getPage(tid, pid,  Permissions.READ_ONLY);
        	 return page.iterator();
         }
         

		@Override
		public void open() throws DbException, TransactionAbortedException {
			// TODO Auto-generated method stub
			pagePos=0;
			HeapPageId pid=new HeapPageId(getId(),pagePos);
			//������һ����������һҳ��tuples
			tuplesInPage=getTuplesInPage(pid);
		}

		@Override
		public boolean hasNext() throws DbException, TransactionAbortedException {
			// TODO Auto-generated method stub
			//�ѹر�
			if(tuplesInPage==null)return false;
			//��ǰҳ����tupleδ����
			else if(tuplesInPage.hasNext())return true;
			//��һҳ�Ƿ���Ҫ������,HeapFile�е�ҳ����Ϊ0,1��... numPages���� - 1
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
		    	throw new NoSuchElementException("��ȫ���رջ���û��tupleʣ�࣡");
		    }
		    return tuplesInPage.next();
		}

		@Override
		public void rewind() throws DbException, TransactionAbortedException {
			// TODO Auto-generated method stub
			//���³�ʼ��
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

