package EasySeats;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import javax.swing.JOptionPane;

public class shutdownControl
{
    public void shutdownFile()
    {
        //Create the control for a group shutdown and reboot policy
        
        String fileLocation = "/etc/polkit-1/rules.d/20-prevent-shutdown.rules";
        File thisIsTheFile = new File(fileLocation);

        if(!thisIsTheFile.exists())
        {
            try
            {
                FileOutputStream OutStr;    
                OutStr = new FileOutputStream(thisIsTheFile);
            
                OutputStreamWriter outWrite = new OutputStreamWriter(OutStr);

                Writer writer = new BufferedWriter(outWrite);
                writer.write("polkit.addRule(function(action, subject) {\n");
                writer.write("    if ((action.id == \"org.freedesktop.login1.power-off-multiple-sessions\" ||\n");
                writer.write("         action.id == \"org.freedesktop.login1.reboot-multiple-sessions\") &&\n");
                writer.write("         subject.isInGroup(\"shutdown\")) {\n");
                writer.write("            return subject.active ? polkit.Result.AUTH_ADMIN : polkit.Result.NO;\n");
                writer.write("    }\n");
                writer.write("});");
                writer.close();
                
                System.out.println("The rule was created at: " + fileLocation);
            }
            catch (FileNotFoundException ex) //FileNotFoundException
            {
                JOptionPane.showMessageDialog(null,
                        "Insufficient permissions to create '20-prevent-shutdown.rules' in /etc/polkit-1/rules.d.");
                ex.printStackTrace();
            }
            catch (UnsupportedEncodingException ex) //UnsupportedEncodingException
            {
                ex.printStackTrace();
            }
            catch (IOException ex) //IOException
            {
                ex.printStackTrace();
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,
                    thisIsTheFile + " already exists.");
        }
    }
}
