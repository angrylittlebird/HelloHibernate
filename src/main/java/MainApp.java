import model.A;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class MainApp {
    public static void main(String[] args) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            A a = session.load(A.class, "a");
            System.out.println(a.getCs());
            System.out.println(a.getCs().isEmpty());//debug model is false, run model is true
            // commit transaction
            transaction.commit();
            HibernateUtil.shutdown();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
