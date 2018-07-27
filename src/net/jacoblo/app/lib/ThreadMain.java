package net.jacoblo.app.lib;

public class ThreadMain
{
    public int m_Secs;
    private Runnable m_UpdateTimer;
    private Thread m_Timer;

    public ThreadMain() {
        m_Secs = 0;
        resetTimer();
    }

    public void start() {
        m_Timer.start();
    }

    public void pause() {
      resetTimer();
    }
    
    public void reset() {
      resetTimer();
      m_Secs = 0;
    }
    
    public void resetTimer() {
      if (m_Timer != null && m_Timer.isAlive()) {
        m_Timer.interrupt();
      }
      m_UpdateTimer = new Runnable() {
        public void run() {
          while(true) {
            m_Secs++;
            try{
                Thread.sleep(1000);
            }catch(InterruptedException ie) {
                return;
            }
          }
        }
      };
      m_Timer = new Thread(m_UpdateTimer);
    }

    public static void main(String[] args) {
      ThreadMain tm = new ThreadMain();
      tm.start();
      
      for(int i = 0 ; i < 10; i++ ) {
        System.out.println(tm.m_Secs);
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      
      tm.pause();
      
      
      for(int i = 0 ; i < 10; i++ ) {
        System.out.println(tm.m_Secs);
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      
      tm.start();
      
      for(int i = 0 ; i < 10; i++ ) {
        System.out.println(tm.m_Secs);
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
}
