import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;


class AddressBookDetails extends JFrame {

    // create JFrame and JTable
    JTable table = new JTable();
    JFrame frame = new JFrame();

    // create JLabels
    JLabel labelOrganisationName = new JLabel("Organisation Name: ");
    JLabel labelOrganisationAddress = new JLabel("Organisation Address: ");
    JLabel labelOrganisationPostcode = new JLabel("Organisation Postcode: ");
    JLabel labelOrganisationCity = new JLabel("Organisation City: ");
    JLabel labelMemberFirstName = new JLabel("Member FirstName: ");
    JLabel labelMemberLastName = new JLabel("Member LastName: ");
    JLabel labelMemberAddress = new JLabel("Member Address: ");
    JLabel labelMemberPostcode = new JLabel("Member Postcode: ");
    JLabel labelMemberCity = new JLabel("Member City: ");
    JLabel labelMemberPhoneNumber = new JLabel("Member PhoneNumber: ");

    // create JTextFields
    JTextField textOrganisationName = new JTextField();
    JTextField textOrganisationAddress = new JTextField();
    JTextField textOrganisationPostcode = new JTextField();
    JTextField textOrganisationCity = new JTextField();
    JTextField textMemberFirstName = new JTextField();
    JTextField textMemberLastName = new JTextField();
    JTextField textMemberAddress = new JTextField();
    JTextField textMemberPostcode = new JTextField();
    JTextField textMemberCity = new JTextField();
    JTextField textMemberPhoneNumber = new JTextField();

    // create JButtons
    JButton btnAdd = new JButton("Add Records");
    JButton btnDelete = new JButton("Delete Records");
    JButton btnUpdate = new JButton("Edit Records");
    JButton btnLoad = new JButton("Load Records");
    JButton btnSaveData = new JButton("Save Records");
    JButton btnExit = new JButton("Exit");


    // create a table model and set a Column Identifiers to this model
    Object[] columns = {"Organisation Name", "Organisation Address", "Organisation Postcode", "Organisation City", " Member FirstName", "Member LastName",
            "Member Address", "Member Postcode", "Member City", "Member PhoneNumber"};
    DefaultTableModel model = new DefaultTableModel();

    // create an array of objects to set the row data
    Object[] row = new Object[10];

    public AddressBookDetails() {

        model.setColumnIdentifiers(columns);

        //sets the JTable to uneditable
        table.setDefaultEditor(Object.class, null);

        // set the model to the table
        table.setModel(model);

        addTextFields();

        // Change A JTable Background Color, Font Size, Font Color, Row Height
        table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(Color.black);
        Font font = new Font("", Font.PLAIN, 14);
        table.setFont(font);
        table.setRowHeight(25);
        table.setAutoCreateRowSorter(true);

        btnAdd.setBounds(2, 202, 107, 25);
        btnUpdate.setBounds(111, 202, 107, 25);
        btnDelete.setBounds(220, 202, 121, 25);
        btnSaveData.setBounds(1245, 229, 113, 25);
        btnLoad.setBounds(1245, 202, 113, 25);
        btnExit.setBounds(1251, 289, 107, 25);


        // create JScrollPane
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0, 0, 1360, 200);

        frame.setLayout(null);
        frame.add(pane);
        frame.setTitle("Address Book");

        // add JButtons to the JFrame
        frame.add(btnAdd);
        frame.add(btnDelete);
        frame.add(btnUpdate);
        frame.add(btnSaveData);
        frame.add(btnLoad);
        frame.add(btnExit);

        //sets a tooltip text for the buttons 'Delete Records' and 'Save Records' to inform the user of their function
        btnDelete.setToolTipText("Select the record that you would like to delete and then press the 'Delete Records' button.");
        btnSaveData.setToolTipText("Saves the current records.");
        btnLoad.setToolTipText("Load data from the existing records.");
        btnUpdate.setToolTipText("Select the record that you would like to edit and then press the 'Edit Records' button");
        btnAdd.setToolTipText("Fill out the TextFields below and press 'Add Records' to add a new record.");

        //window size
        frame.setSize(1375, 355);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // get selected row data From table to TextFields
        table.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    // i = the index of the selected row
                    int i = table.getSelectedRow();

                    textOrganisationName.setText(model.getValueAt(i, 0).toString());
                    textOrganisationAddress.setText(model.getValueAt(i, 1).toString());
                    textOrganisationPostcode.setText(model.getValueAt(i, 2).toString());
                    textOrganisationCity.setText(model.getValueAt(i, 3).toString());
                    textMemberFirstName.setText(model.getValueAt(i, 4).toString());
                    textMemberLastName.setText(model.getValueAt(i, 5).toString());
                    textMemberAddress.setText(model.getValueAt(i, 6).toString());
                    textMemberPostcode.setText(model.getValueAt(i, 7).toString());
                    textMemberCity.setText(model.getValueAt(i, 8).toString());
                    textMemberPhoneNumber.setText(model.getValueAt(i, 9).toString());

                } catch(NullPointerException err){

                }
            }
        });

        //actionListener for the 'Add Records' button on the main frame
        btnAdd.addActionListener(e ->
        {
            row[0] = textOrganisationName.getText();
            row[1] = textOrganisationAddress.getText();
            row[2] = textOrganisationPostcode.getText();
            row[3] = textOrganisationCity.getText();
            row[4] = textMemberFirstName.getText();
            row[5] = textMemberLastName.getText();
            row[6] = textMemberAddress.getText();
            row[7] = textMemberPostcode.getText();
            row[8] = textMemberCity.getText();
            row[9] = textMemberPhoneNumber.getText();

            textOrganisationName.setText("");
            textOrganisationAddress.setText("");
            textOrganisationPostcode.setText("");
            textOrganisationCity.setText("");
            textMemberFirstName.setText("");
            textMemberLastName.setText("");
            textMemberAddress.setText("");
            textMemberPostcode.setText("");
            textMemberCity.setText("");
            textMemberPhoneNumber.setText("");

            // add row to the model
            model.addRow(row);
        });
        //actionListener for the 'Edit Records' button on the main frame
        btnUpdate.addActionListener(e ->
        {
            // i = the index of the selected row
            int i = table.getSelectedRow();

            if (i >= 0) {
                model.setValueAt(textOrganisationName.getText(), i, 0);
                model.setValueAt(textOrganisationAddress.getText(), i, 1);
                model.setValueAt(textOrganisationPostcode.getText(), i, 2);
                model.setValueAt(textOrganisationCity.getText(), i,3);
                model.setValueAt(textMemberFirstName.getText(), i, 4);
                model.setValueAt(textMemberLastName.getText(), i, 5);
                model.setValueAt(textMemberAddress.getText(), i, 6);
                model.setValueAt(textMemberPostcode.getText(), i, 7);
                model.setValueAt(textMemberCity.getText(), i, 8);
                model.setValueAt(textMemberPhoneNumber.getText(), i, 9);
            } else {
                System.out.println("Update Error");
            }
        });
        //actionListener for the 'Delete Records' button on the main frame
        btnDelete.addActionListener(e ->
        {
            deleteRecord();

            textOrganisationName.setText("");
            textOrganisationAddress.setText("");
            textOrganisationPostcode.setText("");
            textOrganisationCity.setText("");
            textMemberFirstName.setText("");
            textMemberLastName.setText("");
            textMemberAddress.setText("");
            textMemberPostcode.setText("");
            textMemberCity.setText("");
            textMemberPhoneNumber.setText("");
        });
        //actionListener for the 'Load Records' button on the main frame
        btnLoad.addActionListener(e ->
        {
            DefaultTableModel dm = (DefaultTableModel)table.getModel();
            dm.getDataVector().removeAllElements();
            readData();
        });
        //actionListener for the 'Save Records' button on the main frame
        btnSaveData.addActionListener(e ->
        {
            writeData();
        });
        //actionListener for the 'Exit' button on the main frame
        btnExit.addActionListener(e ->
        {
            System.exit(0);
        });
    }
    //method that handles 'add record' operation
    private void addTextFields()
    {
        frame.setLayout(null);
        frame.setSize(395, 403);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Add New Records");


        // add JLabels to the JFrame - Frame
        frame.add(labelOrganisationName);
        frame.add(labelOrganisationAddress);
        frame.add(labelOrganisationPostcode);
        frame.add(labelOrganisationCity);
        frame.add(labelMemberFirstName);
        frame.add(labelMemberLastName);
        frame.add(labelMemberAddress);
        frame.add(labelMemberPostcode);
        frame.add(labelMemberCity);
        frame.add(labelMemberPhoneNumber);

        // add JTextFields to the JFrame - Frame
        frame.add(textOrganisationName);
        frame.add(textOrganisationAddress);
        frame.add(textOrganisationPostcode);
        frame.add(textOrganisationCity);
        frame.add(textMemberFirstName);
        frame.add(textMemberLastName);
        frame.add(textMemberAddress);
        frame.add(textMemberPostcode);
        frame.add(textMemberCity);
        frame.add(textMemberPhoneNumber);

        //places JLabels onto the JFrame Frame
        labelOrganisationName.setBounds(7, 225, 140, 25);
        labelOrganisationAddress.setBounds(193, 225, 140, 25);
        labelOrganisationPostcode.setBounds(380, 225, 140, 25);
        labelOrganisationCity.setBounds(567, 225, 140, 25);
        labelMemberFirstName.setBounds(7, 268, 140, 25);
        labelMemberLastName.setBounds(193, 268, 140, 25);
        labelMemberAddress.setBounds(380, 268, 140, 25);
        labelMemberPostcode.setBounds(567, 268, 140, 25);
        labelMemberCity.setBounds(754, 268, 140, 25);
        labelMemberPhoneNumber.setBounds(942, 268, 140, 25);

        //places JTextFields onto the JFrame Frame
        textOrganisationName.setBounds(5, 246, 175, 25);
        textOrganisationAddress.setBounds(191, 246, 175, 25);
        textOrganisationPostcode.setBounds(378, 246, 175, 25);
        textOrganisationCity.setBounds(566, 246, 175, 25);
        textMemberFirstName.setBounds(5, 288, 175, 25);
        textMemberLastName.setBounds(191, 288, 175, 25);
        textMemberAddress.setBounds(378, 288, 175, 25);
        textMemberPostcode.setBounds(566, 288, 175, 25);
        textMemberCity.setBounds(754, 288, 175, 25);
        textMemberPhoneNumber.setBounds(942, 288, 175, 25);

    }
    //method that handles 'delete record' operation
    private void deleteRecord()
    {
        // i = the index of the selected row
        int i = table.getSelectedRow();
        if (i >= 0) {
            // remove a row from JTable
            model.removeRow(i);
        } else {
            System.out.println("Delete Error");
        }

    }

    //method that writes the currently displayed data into the file 'records.txt'
    private void writeData(){
        try {
            File file = new File("records.txt"); //declaring the path of the file

            if (file.createNewFile()){
                System.out.println("File is created!");
            }else{
                System.out.println("File already exists.");
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            //rows
            for (int i = 0; i < table.getRowCount(); i++) {

                for (int j = 0; j < table.getColumnCount(); j++) {
                    String value = (String) table.getModel().getValueAt(i, j);
                    if ((value == null || "null".equals(value))) {
                        value = "";
                    }
                    bw.write(value + ";"); //write the contents to the file
                }
                bw.write("/");
                bw.newLine();
            }
            bw.close();
            fw.close();
            System.out.println("Files written.");

        } catch (IOException e2) {
            System.out.println(e2);
        }
    }
    //method that reads the contents of 'records.txt' into the JTable
    private void readData(){
        String line = null;
        try {
            File file = new File("records.txt");
            FileReader fr = new FileReader(file.getAbsoluteFile());
            BufferedReader br = new BufferedReader(fr);

            StringBuilder builder = new StringBuilder();
            while ((line = br.readLine()) != null) {
                builder.append(line);
            }
            String[] lineArray = builder.toString().split("/");
            for (String currentLine : lineArray) {
                String[] dataArray = currentLine.split(";");
                ((DefaultTableModel) table.getModel()).addRow(dataArray);
            }
            br.close();
            System.out.println("Files loaded.");

        } catch (IOException e3) {
            System.out.println(e3);
        }
    }
}