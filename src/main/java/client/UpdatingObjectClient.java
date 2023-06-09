package client;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;
import entity.Message;

public class UpdatingObjectClient {
	public static void main(String[] args) {  
                Session session = HibernateUtil.getSessionFactory().openSession();
                Transaction txn = session.getTransaction();
                try {
                        txn.begin();

                        //Updating Message[id=2L]
                        Message message = (Message) session.get(Message.class, 3L);
                        System.out.println(message);
                        
                        message.setText("Hello Automatic Dirty Checking!");       
                        
                        txn.commit(); 

                        System.out.println(message);
                }	catch(Exception e) {
                        if(txn != null) { txn.rollback(); }
                        e.printStackTrace();
                }	finally {
                        if(session != null) { 
                                session.close();  }
                }
	
	}
}

