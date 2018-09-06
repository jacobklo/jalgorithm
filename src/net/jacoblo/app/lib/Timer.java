package net.jacoblo.app.lib;

import java.util.concurrent.TimeUnit;

public class Timer {
  private int m_Secs;
  private Thread m_Timer;

  public Timer() {
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

  @Override
  public String toString() {
    long hours = TimeUnit.SECONDS.toHours((m_Secs / 3600));
    long mins = TimeUnit.SECONDS.toMinutes((m_Secs / 60) % 60);
    long secs = TimeUnit.SECONDS.toSeconds(m_Secs % 60);

    return (hours > 0 ? hours + ":" : "") + (mins > 0 ? mins + ":" : "") + secs;
  }

  public int getTimeNow() {
    return m_Secs;
  }

  private void resetTimer() {
    if (m_Timer != null && m_Timer.isAlive()) {
      m_Timer.interrupt();
    }
    Runnable updateTimer = new Runnable() {
      public void run() {
        while (true) {
          m_Secs++;
          try {
            Thread.sleep(1000);
          } catch (InterruptedException ie) {
            return;
          }
        }
      }
    };
    m_Timer = new Thread(updateTimer);
  }
}
