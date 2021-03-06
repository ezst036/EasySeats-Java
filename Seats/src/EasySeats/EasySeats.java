package EasySeats;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/*
 * EasySeats GUI is an attempt to streamline and make the process of multi-seat
 * computing on Linux distributions easier.  Currently, an array of arrays is
 * used, the second array consisting of four slots:
 *
 * 1) Device address
 * 2) Device name
 * 3) Device array position
 * 4) Current seat assignment
 * 5) New seat assignment
 * 6) Return to seat zero
 *
 */

public class EasySeats extends javax.swing.JFrame
{
    ArrayList seatZeroStatus = new ArrayList();
    ArrayList seatOneStatus = new ArrayList();
    
    //Array of Arrays
    List<String[]> easySeatRows = new ArrayList<>();
    
    DefaultListModel allDevicesModel = new DefaultListModel();
    DefaultListModel seatOneModel = new DefaultListModel();
    
    //Make systemd available everywhere
    sdAccess systemd = new sdAccess();
    
    boolean haveDevices = false;
    
    public EasySeats()
    {
        initComponents();
        
        addButtonSeatOne.setVisible(false);
        removeButtonSeatOne.setVisible(false);
    }
        
    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EasySeats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EasySeats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EasySeats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EasySeats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new EasySeats().setVisible(true);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        tabbedPane = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        getDevicesButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        statusResult = new javax.swing.JTextArea();
        clearButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        addButtonSeatOne = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        removeButtonSeatOne = new javax.swing.JButton();
        assignButton = new javax.swing.JButton();
        seatSelectDropDown = new javax.swing.JComboBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        MenuExit = new javax.swing.JMenuItem();
        optionsMenu = new javax.swing.JMenu();
        MenuGetSystemDevices = new javax.swing.JMenuItem();
        MenuAddSeat = new javax.swing.JMenuItem();
        MenuRemoveSeat = new javax.swing.JMenuItem();
        MenuClearAllSeats = new javax.swing.JMenuItem();
        MenuShutdownControl = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        getDevicesButton.setText("Get system devices");
        getDevicesButton.setToolTipText("");
        getDevicesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getDevicesButtonActionPerformed(evt);
            }
        });

        statusResult.setColumns(20);
        statusResult.setRows(5);
        jScrollPane2.setViewportView(statusResult);

        clearButton.setText("Clear status");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(getDevicesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(getDevicesButton)
                    .addComponent(clearButton))
                .addContainerGap())
        );

        tabbedPane.addTab("Seat0 status", jPanel2);

        jScrollPane1.setViewportView(jList1);

        addButtonSeatOne.setText("Add");
        addButtonSeatOne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonSeatOneActionPerformed(evt);
            }
        });

        jScrollPane3.setInheritsPopupMenu(true);

        jScrollPane3.setViewportView(jList2);

        removeButtonSeatOne.setText("Remove");
        removeButtonSeatOne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonSeatOneActionPerformed(evt);
            }
        });

        assignButton.setText("Assign");
        assignButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignButtonActionPerformed(evt);
            }
        });

        seatSelectDropDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seatSelectDropDownActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(removeButtonSeatOne, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addButtonSeatOne, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(assignButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(seatSelectDropDown, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(287, 287, 287)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(seatSelectDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(83, 83, 83)
                                .addComponent(addButtonSeatOne)
                                .addGap(18, 18, 18)
                                .addComponent(removeButtonSeatOne)
                                .addGap(111, 111, 111)
                                .addComponent(assignButton)
                                .addGap(0, 175, Short.MAX_VALUE))
                            .addComponent(jScrollPane3)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );

        tabbedPane.addTab("Multi pci-e cards", null, jPanel1, "");

        fileMenu.setText("File");

        MenuExit.setText("Exit");
        MenuExit.setToolTipText("");
        MenuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuExitActionPerformed(evt);
            }
        });
        fileMenu.add(MenuExit);

        jMenuBar1.add(fileMenu);

        optionsMenu.setText("Options");

        MenuGetSystemDevices.setText("Get seat zero");
        MenuGetSystemDevices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuGetSystemDevicesActionPerformed(evt);
            }
        });
        optionsMenu.add(MenuGetSystemDevices);

        MenuAddSeat.setText("New seat");
        MenuAddSeat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuAddSeatActionPerformed(evt);
            }
        });
        optionsMenu.add(MenuAddSeat);

        MenuRemoveSeat.setText("Remove last seat");
        MenuRemoveSeat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuRemoveSeatActionPerformed(evt);
            }
        });
        optionsMenu.add(MenuRemoveSeat);

        MenuClearAllSeats.setText("Clear all seats");
        MenuClearAllSeats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuClearAllSeatsActionPerformed(evt);
            }
        });
        optionsMenu.add(MenuClearAllSeats);

        MenuShutdownControl.setText("Reboot control");
        MenuShutdownControl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuShutdownControlActionPerformed(evt);
            }
        });
        optionsMenu.add(MenuShutdownControl);

        jMenuBar1.add(optionsMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane)
        );

        tabbedPane.getAccessibleContext().setAccessibleName("Multi-card");

        pack();
    }// </editor-fold>                        

    private void getDevicesButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        if (haveDevices == true)
        {
            //Do not run this method a second time until cleared
        }
        else
        {
            getDevices("seat0");
            addToTextArea();
        }
    }                                                
    
    private void getDevices(String seatName)
    {
        addButtonSeatOne.setVisible(true);
        removeButtonSeatOne.setVisible(true);
        
        if (haveDevices == true)
        {
            //Do not run this method a second time until cleared
            return;
        }
        
        String[] theseAreTheSeats = systemd.howManySeats();
        
        //Out of order test array
        //String[] theseAreTheSeats = { "seat1", "seat-2", "seat0", "azSeat-19" };
        
        for(int i = 0; i < theseAreTheSeats.length; i++)
        {
            if(theseAreTheSeats[i] == "seat0")
            {
                /*
                 * A simple Arrays.sort will not work here.
                 *
                 * Some linux distros put seats out of order.
                 *
                 * If seat0 is found further down in the list duplicate
                 * the entry found in element zero.  Then set element
                 * zero to seat0 after the loop completes.
                 *
                 */
                theseAreTheSeats[i] = theseAreTheSeats[0];
            }
        }
        
        //Set element zero to seat0
        theseAreTheSeats[0] = "seat0";
        
        for(int i = 0; i < theseAreTheSeats.length; i++)
        {
            //Read directly from systemd
            populateSeatStatussystemd(theseAreTheSeats[i], i);

            //Declare objects for use in the method
            int loopCntr = 0;
            int devCounter = easySeatRows.size();

            if(i == 0)
            {
                for (Object holder : seatZeroStatus)
                {
                    //Add loop counter, device counter, and object holder
                    devCounter = populateDevArray(loopCntr, devCounter, i, holder.toString());
                    loopCntr++;
                }
            }
            else
            {
                for (Object holder : seatOneStatus)
                {
                    //Add loop counter, device counter, and string holder
                    devCounter = populateDevArray(loopCntr, devCounter, i, holder.toString());
                    loopCntr++;
                }
            }
            
            addDevsToJList(i, false);
        }
        
        //Disable the get devices function.
        haveDevices = true;

        resetDrop();
    }
    
    private void addDevsToJList(int listSel, boolean setSubSeat)
    {
        //Seat model has to be emptied, otherwise repeat values will be added.
        allDevicesModel.removeAllElements();
        seatOneModel.removeAllElements();
        
        try
        {
            //Adds dev names only to the first control element
            for(int i = 0; i < easySeatRows.size(); i++)
            {
                if (Integer.parseInt(easySeatRows.get(i)[3]) == 0)
                {
                    allDevicesModel.addElement(easySeatRows.get(i)[1]);
                }
                else if (Integer.parseInt(easySeatRows.get(i)[3]) == listSel)
                {
                    seatOneModel.addElement(easySeatRows.get(i)[1]);
                }
            }
        }
        catch (NumberFormatException ex)
        {
            clearAll();
            statusResult.append("Java version error, found " +
                    System.getProperty("java.version") + ".  Please report.");
            return;
        }
        
        if (setSubSeat == true)
        {
            jList2.setModel(seatOneModel);
        }
        else
        {
            jList1.setModel(allDevicesModel);
        }
    }
    
    private void MenuExitActionPerformed(java.awt.event.ActionEvent evt) {                                         
        System.exit(0);
    }                                        
        
    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        clearAll();
    }                                           
    
    public void clearAll()
    {
        allDevicesModel.removeAllElements();
        seatOneModel.removeAllElements();
        jList2.setModel(seatOneModel);
        statusResult.setText(null);
        addButtonSeatOne.setVisible(false);
        removeButtonSeatOne.setVisible(false);
        easySeatRows.clear();
        
        if (seatSelectDropDown.getItemCount() > 1)
        {
            //Clear all additionally listed items
            for (int i = 1; i < seatSelectDropDown.getItemCount(); i++)
            {
                seatSelectDropDown.removeItemAt(i);
            }
        }
        
        //Enable the get devices function
        haveDevices = false;
    }
    
    public void resetDrop()
    {
        //How many seats does systemd report
        String[] defaultSeats = systemd.howManySeats();
        
        //Do not want to leave seats in the list if they have been removed
        for (int i = 0; i < seatSelectDropDown.getItemCount(); i++)
        {
            seatSelectDropDown.removeItemAt(i);
        }
        
        if (defaultSeats.length == 1)
        {
            seatSelectDropDown.addItem("seat1");
        }
        else
        {
            //List all pre-existing seats not identified as seat0 in the drop down
            for (String seat: defaultSeats)
            {
                if (!seat.equals("seat0"))
                {
                    System.out.println(seat + " was found.");
                    seatSelectDropDown.addItem(seat);
                }
            }
        }
    }
        
    private void MenuClearAllSeatsActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        systemd.clearAllSeats();
    }                                                 

    private void MenuShutdownControlActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        shutdownControl policyRule = new shutdownControl();
        policyRule.shutdownFile();
    }                                                   

    private void MenuGetSystemDevicesActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        if (haveDevices == true)
        {
            //Do not run this method a second time until cleared
        }
        else
        {
            getDevices("seat0");
            addToTextArea();
        }
    }                                                    

    private void MenuAddSeatActionPerformed(java.awt.event.ActionEvent evt) {                                            
        int dropCount = seatSelectDropDown.getItemCount() + 1;
        
        String newSeatName = "seat" + dropCount;
        
        //Prevent duplicate seat names
        for (int i = 0; i < seatSelectDropDown.getItemCount(); i++)
        {
            if(seatSelectDropDown.getItemAt(i).equals(newSeatName))
            {
                dropCount++;
                newSeatName = "seat" + dropCount;
            }
        }
        
        int choice = JOptionPane.showConfirmDialog(null,
                "Would you like to add another seat: " + newSeatName
                , "New seat", JOptionPane.YES_NO_OPTION);
        
        if (choice == JOptionPane.YES_OPTION)
        {
            seatSelectDropDown.addItem(newSeatName);
        }
    }                                           

    private void MenuRemoveSeatActionPerformed(java.awt.event.ActionEvent evt) {                                               
        /*
        * Method will remove the item from the drop down
        * list only, or terminate the corresponding seat
        *
        */
        
        int dropCount = seatSelectDropDown.getItemCount();
        int dropSize = seatSelectDropDown.getItemCount() - 1;
        String seatName = (String) seatSelectDropDown.getItemAt(dropSize);
        
        int choice = JOptionPane.showConfirmDialog(null,
                "Would you like to remove the last seat?  " + seatName
                , "Seat removal", JOptionPane.YES_NO_OPTION);
        
        String currentSeats[] = systemd.howManySeats();
        
        //Seat 1 should always be an option and not removable
        if (dropCount > 1 && choice == JOptionPane.YES_OPTION)
        {
            for(int i = 0; i < currentSeats.length; i++)
            {
                String line = currentSeats[i];
		if(seatName.equals(line))
                {
                    systemd.loginctlSingleSeat("", seatName, "terminate-seat");
                }
            }
            
            seatSelectDropDown.removeItemAt(dropSize);
        }
    }                                              

    private void assignButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        if (easySeatRows == null)
        {
            //Handle null pointer exception
            return;
        }
        
        boolean returnDev = false;
        
        StringBuilder deviceStringList = new StringBuilder();
        int counter = 0;

        for(int i = 0 ; i < easySeatRows.size(); i++)
        {
            if (Integer.parseInt(easySeatRows.get(i)[4]) !=
                Integer.parseInt(easySeatRows.get(i)[5]))
            {
                /*
                * One item found.  Stringbuilder appends, so
                * can't use its length property when multiple
                * devices are being added at once by the user
                *
                */
                counter++;
                
                if (Integer.parseInt(easySeatRows.get(i)[4]) <
                    Integer.parseInt(easySeatRows.get(i)[5]))
                {
                    returnDev = true;
                }
                
                //Use stringbuilder to create a single long string consisting of several devices
                deviceStringList.append(easySeatRows.get(i)[0]);

                //Append an empty space after the device found to make way for the next device
                deviceStringList.append(" ");
            }
        }
                
        if (counter == 0)
        {
            JOptionPane.showMessageDialog(null, "No new items found for " + seatSelectDropDown.getItemAt(seatSelectDropDown.getSelectedIndex())
                + ".  Did you assign the device to the correct seat?");
        }
        else if (returnDev == true)
        {
            String seatName = (String) seatSelectDropDown.getItemAt(seatSelectDropDown.getSelectedIndex());
            systemd.loginctlSingleSeat(deviceStringList.toString(), "seat0", "attach");
        }
        else if (returnDev == false)
        {
            String seatName = (String) seatSelectDropDown.getItemAt(seatSelectDropDown.getSelectedIndex());
            systemd.loginctlSingleSeat(deviceStringList.toString(), seatName, "attach");
        }
        
        //After assignment set all back to zero
        for(int i = 0; i < easySeatRows.size(); i++)
        {
            easySeatRows.get(i)[4] = "0";
            easySeatRows.get(i)[5] = "0";
        }
    }                                            

    private void removeButtonSeatOneActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        int selIndex = jList2.getSelectedIndex();
        String itemName = null;

        try
        {
            //Item name remains null because user did not select an item from the list
            itemName = jList2.getSelectedValue().toString();
        }
        catch (NullPointerException ex)
        {
            System.out.println("No devices were selected to remove.");
        }

        if (selIndex < 0)
        {
            return;
        }
        
        //Need to determine the device's index before I can change the bit.
        String temp[] = returnDevice(itemName);
        changeDeviceSeatBit(Integer.parseInt(temp[2]), 0, 1);
        
        seatOneModel.removeElementAt(selIndex);
        allDevicesModel.removeAllElements();
        
        addDevsToJList(1, true);
        jList2.setModel(seatOneModel);
    }                                                   

    private void addButtonSeatOneActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        int listIndex = jList1.getSelectedIndex();
        String itemName = null;

        try
        {
            //Item name remains null because user did not select an item from the list
            itemName = jList1.getSelectedValue().toString();
        }
        catch (NullPointerException ex)
        {
            System.out.println("No devices were selected to add.");
        }
                
        if (listIndex < 0)
        {
            return;
        }

        String temp[] = returnDevice(itemName);
        allDevicesModel.removeElementAt(listIndex);
        int selIndex = seatSelectDropDown.getSelectedIndex() + 1;
        
        //This value will always be zero unless the stored index is accessed instead of the jlist index.
        changeDeviceSeatBit(Integer.parseInt(temp[2]), selIndex, 0);

        //Seat model has to be emptied, otherwise repeat values will be added.
        seatOneModel.removeAllElements();

        for(int i = 0; i < easySeatRows.size(); i++)
        {
            int bitHolder = Integer.parseInt(easySeatRows.get(i)[3]);

            //Any time the bitholder value equals index, add it to the model.
            if (bitHolder == selIndex)
            {
                seatOneModel.addElement(easySeatRows.get(i)[1]);
            }
        }

        jList2.setModel(seatOneModel);
    }                                                

    private void seatSelectDropDownActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        int combItem = seatSelectDropDown.getSelectedIndex();
        
        seatOneStatus.clear();
        
        addDevsToJList(combItem + 1, true);
    }                                                  
    
    public String[] returnDevice(String searchString)
    {
        //Method searches the name to find the address
        String[] stringOne = {"", "", ""};
        String stringTwo = "";
        
        for(int i = 0; i < easySeatRows.size(); i++)
        {
            stringTwo = easySeatRows.get(i)[1];
            
            if (stringTwo.contains(searchString))
            {
                //address
                stringOne[0] = easySeatRows.get(i)[0];
                
                //name
                stringOne[1] = stringTwo;
                
                //index
                stringOne[2] = easySeatRows.get(i)[2];
                break;
            }
        }
        
        return stringOne;
    }
    
    public void changeDeviceSeatBit(int searchBit, int selectedSeat, int returnSeat)
    {
        //Use ints in a way similar to booleans
        for(int i = 0; i < easySeatRows.size(); i++)
        {
            int bitHolder = Integer.parseInt(easySeatRows.get(i)[2]);
                        
            if (returnSeat > 0 && bitHolder == searchBit)
            {
                //Method was called on a removal
                easySeatRows.get(searchBit)[5] = "1";
            }
            
            if (bitHolder == searchBit)
            {
                //Match the value in the stored array[][x]
                easySeatRows.get(searchBit)[3] = Integer.toString(selectedSeat);
                easySeatRows.get(searchBit)[4] = Integer.toString(selectedSeat);
            }
        }
    }
    
    public void populateSeatStatussystemd(String seat, int position)
    {
        statusResult.setText(null);
        seatZeroStatus.clear();
        
        String[] seatResults = systemd.populateSeatStatussystemd(seat);

        //Read each line, put into arraylist
        int counter = 0;
        int loopCntr = 0;
        
        String javaVer = System.getProperty("java.version");
        
        System.out.println("\nJava Version: " + javaVer);
        System.out.println("Java Runtime Version: " + System.getProperty("java.runtime.version"));
        
        if (javaVer.compareTo("1.9") == -1 && position != 0)
        {
            System.out.println("\nJava Version less than 1.9.");
            
            //The counter should begin with one extra
            loopCntr++;
        }
        
        for (int i = 0; i < seatResults.length; i++)
        {
            //Throw out the first three results
            if (loopCntr > 2)
            {
                String holdResult = charCleaner(seatResults[i]);
                if (position == 0)
                {
                    seatZeroStatus.add(counter, holdResult);
                }
                else
                {
                    seatOneStatus.add(counter, holdResult);
                }

                counter++;
            }

            loopCntr++;
        }
    }
    
    public int populateDevArray(int loopCntr, int devCounter, int seatNum, String strHolder)
    {
        String[] rowHolder = {"", "", "", "", "", ""};
        
        if (loopCntr % 2 == 0)
        {
            //Add device address
            rowHolder[0] = strHolder;
            
            //Add temporarily
            easySeatRows.add(rowHolder);
        }

        if (loopCntr % 2 != 0)
        {
            //set the first container
            rowHolder[0] = easySeatRows.get(devCounter)[0];
            
            //Add device name
            rowHolder[1] = strHolder;

            //Add device position
            rowHolder[2] = Integer.toString(devCounter);

            //Add device current seat
            rowHolder[3] = Integer.toString(seatNum);
            
            //Comparison bits for seat assignment.
            rowHolder[4] = rowHolder[5] = "0";
            
            //Remove temporary placeholder
            easySeatRows.remove(devCounter);
            
            //Add full row
            easySeatRows.add(rowHolder);

            devCounter++;
        }
        
        return devCounter;
    }
    
    public void addToTextArea()
    {
        for(int i = 0; i < easySeatRows.size(); i++)
        {
            //The textarea in the main window should get all items for reference purposes
            statusResult.append(easySeatRows.get(i)[0] + "\n");
            statusResult.append(easySeatRows.get(i)[1] + "\n");
        }
    }
    
    public String charCleaner(String line)
    {
        //results holder variable
        int heldStrLen;
        int cutHolder = 0;
        
        String holdToStr = line;
        
        heldStrLen = holdToStr.length();
        
        for(int i = 0; i < heldStrLen; i++)
        {
            char firstChar = holdToStr.charAt(i);
            
            if (firstChar == '[' || firstChar == '/' || Character.isLetter(firstChar))
            {
                cutHolder = i;
                break;
            }
        }

        String holdToSubstr = holdToStr.substring(cutHolder, heldStrLen);
        
        return holdToSubstr;
    }

    // Variables declaration - do not modify                     
    private javax.swing.JMenuItem MenuAddSeat;
    private javax.swing.JMenuItem MenuClearAllSeats;
    private javax.swing.JMenuItem MenuExit;
    private javax.swing.JMenuItem MenuGetSystemDevices;
    private javax.swing.JMenuItem MenuRemoveSeat;
    private javax.swing.JMenuItem MenuShutdownControl;
    private javax.swing.JButton addButtonSeatOne;
    private javax.swing.JButton assignButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JMenu fileMenu;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton getDevicesButton;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JMenu optionsMenu;
    private javax.swing.JButton removeButtonSeatOne;
    private javax.swing.JComboBox seatSelectDropDown;
    private javax.swing.JTextArea statusResult;
    private javax.swing.JTabbedPane tabbedPane;
    // End of variables declaration                   
}
