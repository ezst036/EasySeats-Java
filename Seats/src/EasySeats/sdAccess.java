package EasySeats;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import javax.swing.JOptionPane;

//Class for accessing systemd on the command line

public class sdAccess
{
    public String[] populateSeatZeroStatussystemd()
    {
        String seatNum = "0";
        
        String[] seatZeroLoginctl = {"/bin/sh", "-c", "loginctl seat-status seat" + seatNum};
        
        ArrayList<String> sdResults = new ArrayList<>();
        
        try
        {
            Runtime rt = Runtime.getRuntime();
            
            //Get All Devices from the command line
            Process proc = rt.exec(seatZeroLoginctl);
            
            BufferedReader results = new BufferedReader(new InputStreamReader(proc.getInputStream(), "UTF8"));
            
            proc.waitFor();
            
            String line;
            while ((line = results.readLine()) != null)
            {
                sdResults.add(line);
            }
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        catch (InterruptedException ex)
        {
            ex.printStackTrace();
        }
        
        String[] returnArray = new String[sdResults.size()];
        returnArray = sdResults.toArray(returnArray);
        return returnArray;
    }
    
    public void loginctlSingleSeat(String devAddress, int seatNum, String enjoin)
    {
        //Method can attach or terminate seats
        String seatName = "seat" + Integer.toString(seatNum);
        
        Runtime rt = Runtime.getRuntime();
        
        try
        {
            String[] seatAttach = {"/bin/sh", "-c", "loginctl " + enjoin + " "
                    + seatName + " " + devAddress};
            Process proc = rt.exec(seatAttach);
            
            System.out.println("The command that was sent was: " + seatAttach[2]);
            System.out.println("");
            System.out.println("To create a seat, always remember to start with a video card.");
            System.out.println("");
            
            proc.waitFor();
        }
        catch (IOException ex) //IOException
        {
            ex.printStackTrace();
        }
        catch (InterruptedException ex) //InterruptedException
        {
            ex.printStackTrace();
        }
    }
    
    public void clearAllSeats()
    {
        int choice = JOptionPane.showConfirmDialog(null,
                "This will set your computer to single seat, do you wish to continue?"
                , "Remove every seat", JOptionPane.YES_NO_OPTION);
        
        if (choice == JOptionPane.YES_OPTION)
        {
            Runtime rt = Runtime.getRuntime();
        
            try
            {
                String[] clearAllSeats = {"/bin/sh", "-c", "loginctl flush-devices"};
                Process proc = rt.exec(clearAllSeats);

                System.out.println("The command that was sent was: " + clearAllSeats[2]);

                proc.waitFor();
            }
            catch (IOException ex) //IOException
            {
                ex.printStackTrace();
            }
            catch (InterruptedException ex) //InterruptedException
            {
                ex.printStackTrace();
            }
        }
    }
    
    public int getsystemdVer()
    {
        ArrayList systemdStatus = new ArrayList();
        
        try
        {
            Runtime rt = Runtime.getRuntime();
            
            //Get All Devices from the command line
            String[] systemdResults = {"/bin/sh", "-c", "systemctl --version"};
            Process proc = rt.exec(systemdResults);
            
            BufferedReader results = new BufferedReader(new InputStreamReader(proc.getInputStream(), "UTF8"));
            
            proc.waitFor();
            
            //results holder variable
            String line;
            
            //Read each line, put into arraylist
            while ((line = results.readLine()) != null)
            {
                systemdStatus.add(line);
                System.out.println(line);
            }
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        catch (InterruptedException ex)
        {
            ex.printStackTrace();
        }
        
        //Get the version number, convert it to string, then remove all non-numeric data
        String digits = systemdStatus.get(0).toString().replaceAll("[^0-9]", "");
        
        int sdVer = Integer.parseInt(digits);
        
        return sdVer;
    }
    
    public String[] howManySeats()
    {
        String[] listSeats = {"/bin/sh", "-c", "loginctl list-seats"};
        
        ArrayList<String> sdResults = new ArrayList<>();
        
        try
        {
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec(listSeats);
            BufferedReader results = new BufferedReader(new InputStreamReader(proc.getInputStream(), "UTF8"));
            proc.waitFor();
            
            //results holder variable
            String line;
            while ((line = results.readLine()) != null)
            {
                sdResults.add(line);
            }
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        catch (InterruptedException ex)
        {
            ex.printStackTrace();
        }
        
        //Return only valid seat names
        String seatTotal = sdResults.get(sdResults.size() - 1);
        int seatTotalNum = parseInt(seatTotal.substring(0,1));
        
        String[] returnArray = new String[seatTotalNum];
        int counter = 0;
        
        for (int i = 1; i < sdResults.size() - 2; i++)
        {
            returnArray[counter] = sdResults.get(i).trim();
            counter++;
        }
        
        return returnArray;
    }
}