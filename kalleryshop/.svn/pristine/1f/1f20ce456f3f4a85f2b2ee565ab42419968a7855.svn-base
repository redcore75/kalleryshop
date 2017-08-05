package kr.co.redcore.util.daemon;

import java.util.*;
import java.io.*;
import java.lang.management.ManagementFactory;
import org.apache.commons.logging.*;

public abstract class ServerDaemon implements Runnable {
	private static Log log = LogFactory.getLog(ServerDaemon.class);

	private List threadList = new ArrayList();

	public final static int SLEEP_TIME = 1000;
	public final static String STATUS_FNAME = "daemon.status";
	public final static String DAEMON_STATUS_SHUTDOWN = "SHUTDOWN";

	public static boolean start = false;
	public static boolean serverDaemon_status = true;
	public static boolean serverDaemon_exception = false;
	public static String status_fname = STATUS_FNAME;
	public static String os_name = System.getProperty("os.name").toLowerCase();

	public void run() {
		log.debug("ServerDaemon Starting...");

		try {
			String pidNumber = getCurrentPidNumber();
			log.debug("ServerDaemon pidNumber : " + pidNumber);

			writeDaemonStatus(pidNumber);

			while (true) {
				String pidNumberTemp = readDaemonStatus();
				if ((pidNumberTemp != null) && pidNumberTemp.trim().equals(DAEMON_STATUS_SHUTDOWN)) {
					log.debug("Received message for shutdown signal...");
					serverDaemon_exception = true;
					break;
				}

				Thread.sleep(SLEEP_TIME);
			}
		} catch (Exception ex) {
			serverDaemon_exception = true;
			log.error(this, ex);
		} finally {
			Iterator it = threadList.iterator();
			while (it.hasNext()) {
				Thread threadObject = (Thread) it.next();
				threadObject.interrupt();
			}

			serverDaemon_status = false;
		}

		log.debug("ServerDaemon Stopping...");
	}

	public abstract void startMainThread();

	public abstract void stopMainThread();

	public void startServerDaemon(String args[]) {
		if (args.length < 1) {
			System.out.println("Usage : MainClass { start | stop }");
		} else {
			if (args.length > 1) {
				if (args[0].equals("start")) {
					start = true;
					status_fname = args[1];
					System.out.println("ServerDaemon Start(" + status_fname + ")....................");
				} else {
					start = false;
					status_fname = args[1];
					System.out.println("ServerDaemon Stop(" + status_fname + ")....................");
				}
			} else {
				if (args[0].equals("start")) {
					start = true;
					status_fname = STATUS_FNAME;
					System.out.println("ServerDaemon Start(" + status_fname + ")....................");
				} else {
					start = false;
					status_fname = STATUS_FNAME;
					System.out.println("ServerDaemon Stop(" + status_fname + ")....................");
				}
			}
		}

		try {
			if (start) {
				if (checkRunningProcesses(readDaemonStatus())) {
					System.out.println("ServerDaemon(" + readDaemonStatus() + ") is running or is shutdown status by Exception !!!....");
					System.exit(0);
				}
			} else {
			}
		} catch (Exception ex) {
			log.debug(this, ex);
		}

		if (start) {
			Thread serverDaemon = new Thread(this);
			serverDaemon.start();

			startMainThread();

			while (true) {
				try {
					if (!serverDaemon_status || serverDaemon_exception) {
						break;
					}

					Thread.sleep(SLEEP_TIME);
				} catch (Exception ex) {
					log.error(this, ex);
				}
			}

			stopMainThread();

			log.debug("Shutdown complete...");
		} else {
			sendShutdownSignal();
		}

		System.exit(0);
	}

	public void sendShutdownSignal() {
		try {
			log.debug("Sending shutdown signal...start...");
			writeDaemonStatus(DAEMON_STATUS_SHUTDOWN);
			log.debug("Sending shutdown signal...end...");
		} catch (Exception ex) {
			log.debug(this, ex);
		}
	}

	public String readDaemonStatus() throws Exception {
		StringBuffer pidNumber = new StringBuffer();
		File fp = new File(status_fname);
		FileReader fr = null;
		BufferedReader in = null;

		if (fp.isFile()) {
			try {
				String readLine = new String();

				fr = new FileReader(fp);
				in = new BufferedReader(fr);

				while ((readLine = in.readLine()) != null) {
					pidNumber.append(readLine);
				}
			} catch (Exception ex) {
				throw ex;
			} finally {
				try {
					in.close();
					fr.close();
				} catch (IOException ex) {
				}
			}
		} else {
			log.debug(status_fname + " not exist!!!....");
		}

		return pidNumber.toString();
	}

	public void writeDaemonStatus(String pidNumber) throws Exception {
		File fp = new File(status_fname);
		FileWriter fw = null;
		BufferedWriter out = null;

		try {
			fw = new FileWriter(fp);
			out = new BufferedWriter(fw);
			out.write(pidNumber);
		} catch (Exception ex) {
			throw ex;
		} finally {
			try {
				out.close();
				fw.close();
			} catch (IOException ex) {
			}
		}
	}

	public String getCurrentPidNumber() {
		String name = ManagementFactory.getRuntimeMXBean().getName();
		return name.substring(0, name.indexOf("@"));
	}

	public List getThreadList() {
		return threadList;
	}

	public void setThreadList(List threadList) {
		this.threadList = threadList;
	}

	public void addThread(Thread threadObject) {
		threadList.add(threadObject);
	}

	public void removeThread(Thread threadObject) {
		threadObject.interrupt();
		threadList.remove(threadObject);
	}

	public void removeThreadAll() {
		Iterator it = threadList.iterator();
		while (it.hasNext()) {
			Thread threadObject = (Thread) it.next();
			threadObject.interrupt();
		}

		threadList.removeAll(threadList);
	}

	public static List listRunningProcesses() throws Exception {
		List processes = new ArrayList();
		BufferedReader br = null;
		try {
			String line;
			Process p = isWindows() ? Runtime.getRuntime().exec("tasklist.exe /nh") : Runtime.getRuntime().exec("ps -ef");
			br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while ((line = br.readLine()) != null) {
				if (!line.trim().equals("")) {
					if(isWindows()) {
						line = line.trim().substring(0, line.trim().length() - 20);
					} else {
						line = line.trim();
					}
					
					processes.add(line);
				}
			}
		} catch (Exception ex) {
			throw ex;
		} finally {
			br.close();
		}

		return processes;
	}

	public static boolean checkRunningProcesses(String pidNumber) throws Exception {
		boolean isRunning = false;
		
		List lrp = listRunningProcesses();
		for(int i = 0; i < lrp.size(); i++) {
			String process = (String)lrp.get(i);			
			if(process.indexOf(pidNumber) > 0) {
				isRunning = true;
				break;
			}
		}
		
		return isRunning;
	}
	
	public static boolean isWindows() {
		return (os_name.indexOf("win") >= 0);
	}

	public static boolean isMac() {
		return (os_name.indexOf("mac") >= 0);
	}

	public static boolean isUnix() {
		return (os_name.indexOf("nix") >= 0 || os_name.indexOf("nux") >= 0 || os_name.indexOf("aix") > 0);
	}

	public static boolean isSolaris() {
		return (os_name.indexOf("sunos") >= 0);
	}
}