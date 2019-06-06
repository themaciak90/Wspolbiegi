import java.util.concurrent.Semaphore;

public class Most {
    static Semaphore normalni = new Semaphore(0);
    static Semaphore zmiana = new Semaphore(0);
    static Semaphore chron = new Semaphore(1);
    static Semaphore mutex = new Semaphore(1);
    volatile private static int licz_norm = 0;
    volatile private static int licz_norm_most = 0;
    volatile private static int licz_zmiana = 0;
    volatile private static int licz_zmiana_most = 0;
    volatile public static boolean zmianaStop = false;
    volatile public static int kierunek_jazdy = 2;


    @SuppressWarnings("Duplicates")
    public void pocz_norm() throws InterruptedException {
        chron.acquire();
        licz_norm++;
        if(licz_zmiana == 0)
        {
            while(licz_norm_most < licz_norm){
                licz_norm_most++;
                normalni.release();
            }
        }
        chron.release();
        normalni.acquire();


    }
    public void kon_norm() throws InterruptedException{
        chron.acquire();
        licz_norm_most--;
        licz_norm--;
        if(licz_norm_most == 0){
            while(licz_zmiana_most < licz_zmiana){
                licz_zmiana_most++;
                zmiana.release();
            }
        }
        chron.release();
    }
    @SuppressWarnings("Duplicates")
    public void pocz_zmian()throws InterruptedException{
        chron.acquire();
        licz_zmiana++;
        if(licz_norm == 0){
            while(licz_zmiana_most < licz_zmiana){
                licz_zmiana_most++;
                zmiana.release();
            }
        }
        chron.release();
        zmiana.acquire();
        mutex.acquire();

    }
    public void kon_zmian() throws InterruptedException{
        mutex.release();
        chron.acquire();
        licz_zmiana_most--;
        licz_zmiana--;
        if(licz_zmiana_most == 0){
            while(licz_norm_most < licz_norm){
                licz_norm_most++;
                normalni.release();
            }
        }
        chron.release();
    }
}

