/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;
import model.ChemicalElement;
import model.PeriodicTable;
import model.ChemicalReaction;
import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 *
 * @author Lucas Fernandes
 */
public class ChemTable extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ChemTable.class.getName());
    private final ReactionController reactionController;
    private final List<ChemicalElement> allElements;
    /**
     * Creates new form ChemTable
     */
    public ChemTable() {
        initComponents();
        reactionController = new ReactionController();
        allElements = new PeriodicTable().getPeriodicTable(); // Save full periodic table
        populatePeriodicTableList(allElements); // populate initial list
        setupSearchField(); // set up placeholder + live search
        
        // Allow double click to add element
        periodicTableList.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            if (evt.getClickCount() == 2) { // double-click
                addElementButtonActionPerformed(null); // call the existing method
            }
        }
    });
        
    }
        private void populatePeriodicTableList(List<ChemicalElement> elements) {
        DefaultListModel<ChemicalElement> model = new DefaultListModel<>();
        for (ChemicalElement element : elements) {
            model.addElement(element);
        }
        periodicTableList.setModel(model);
        periodicTableList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
        
    /** Sets up placeholder behaviour for the search field. */
    private void setupSearchField() {
            searchElementTextField.setText("Search Element");
    searchElementTextField.setForeground(Color.GRAY);

    searchElementTextField.addFocusListener(new java.awt.event.FocusAdapter() {
        @Override
        public void focusGained(java.awt.event.FocusEvent evt) {
            if (searchElementTextField.getText().equals("Search Element")) {
                searchElementTextField.setText("");
                searchElementTextField.setForeground(Color.BLACK);
            }
        }

        @Override
        public void focusLost(java.awt.event.FocusEvent evt) {
            if (searchElementTextField.getText().isEmpty()) {
                searchElementTextField.setText("Search Element");
                searchElementTextField.setForeground(Color.GRAY);
                populatePeriodicTableList(allElements); // restore full list
            }
        }
    });

    // Live search as user types
    searchElementTextField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
        private void updateList() {
            String text = searchElementTextField.getText().trim().toLowerCase();
            if (text.isEmpty() || text.equals("search element")) {
                populatePeriodicTableList(allElements);
                return;
            }

            // Filter elements by symbol only
            List<ChemicalElement> filtered = allElements.stream()
                .filter(e -> e.getSymbol().toLowerCase().contains(text))
                .toList();
            populatePeriodicTableList(filtered);

            // Automatically select the first match if available
            if (!filtered.isEmpty()) {
                periodicTableList.setSelectedIndex(0);
                periodicTableList.ensureIndexIsVisible(0); // scroll to it
            }
        }

        @Override
        public void insertUpdate(javax.swing.event.DocumentEvent e) { updateList(); }
        @Override
        public void removeUpdate(javax.swing.event.DocumentEvent e) { updateList(); }
        @Override
        public void changedUpdate(javax.swing.event.DocumentEvent e) { updateList(); }
    });

    searchElementTextField.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            if (searchElementTextField.getText().equals("Search Element")) {
                searchElementTextField.setText("");
                searchElementTextField.setForeground(Color.BLACK);
            }
        }
    });

        // Live search as user types
        searchElementTextField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            private void updateList() {
                String text = searchElementTextField.getText().trim().toLowerCase();
                if (text.isEmpty() || text.equals("search element")) {
                    populatePeriodicTableList(allElements);
                    return;
                }

                // Filter elements by symbol only
                List<ChemicalElement> filtered = allElements.stream()
                    .filter(e -> e.getSymbol().toLowerCase().contains(text))
                    .toList();
                populatePeriodicTableList(filtered);
            }

            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) { updateList(); }
            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) { updateList(); }
            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) { updateList(); }
        });

        searchElementTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (searchElementTextField.getText().equals("Search Element")) {
                    searchElementTextField.setText("");
                    searchElementTextField.setForeground(Color.BLACK);
                }
            }
        });
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jMenu3 = new javax.swing.JMenu();
        periodicTablePanel = new javax.swing.JPanel();
        periodicTableLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        periodicTableList = new javax.swing.JList<>();
        startReactionButton = new javax.swing.JButton();
        newReactionButton = new javax.swing.JButton();
        addElementButton = new javax.swing.JButton();
        searchElementTextField = new javax.swing.JTextField();
        titlePanel = new javax.swing.JPanel();
        labLabel = new javax.swing.JLabel();
        chemistryLabel = new javax.swing.JLabel();
        reactionPanel = new javax.swing.JPanel();
        reactionInfoLabel = new javax.swing.JLabel();
        productLabel = new javax.swing.JLabel();
        typeLabel = new javax.swing.JLabel();
        productInfoLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        productInfoTextArea = new javax.swing.JTextArea();
        productTextField = new javax.swing.JTextField();
        typeTextField = new javax.swing.JTextField();
        hazardLevelLabel = new javax.swing.JLabel();
        hazardTypeLabel = new javax.swing.JLabel();
        hazardInfoLabel = new javax.swing.JLabel();
        hazardTypeTextField = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        hazardInfoTextArea = new javax.swing.JTextArea();
        hazardLevelTextField = new javax.swing.JTextField();
        authorLabel = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenuList = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();
        helpMenuList = new javax.swing.JMenu();
        manualMenuItem = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        periodicTableLabel.setFont(new java.awt.Font("Adwaita Sans", 1, 14)); // NOI18N
        periodicTableLabel.setText("Periodic Table");

        jScrollPane1.setViewportView(periodicTableList);

        startReactionButton.setText("Start Reaction");
        startReactionButton.addActionListener(this::startReactionButtonActionPerformed);

        newReactionButton.setText("New Reaction");
        newReactionButton.addActionListener(this::newReactionButtonActionPerformed);

        addElementButton.setText("Add Element");
        addElementButton.addActionListener(this::addElementButtonActionPerformed);

        searchElementTextField.setText("Search Element");

        javax.swing.GroupLayout periodicTablePanelLayout = new javax.swing.GroupLayout(periodicTablePanel);
        periodicTablePanel.setLayout(periodicTablePanelLayout);
        periodicTablePanelLayout.setHorizontalGroup(
            periodicTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(periodicTablePanelLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(periodicTableLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, periodicTablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(periodicTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(periodicTablePanelLayout.createSequentialGroup()
                        .addGroup(periodicTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(startReactionButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(searchElementTextField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(periodicTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addElementButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(newReactionButton, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))))
                .addContainerGap())
        );
        periodicTablePanelLayout.setVerticalGroup(
            periodicTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(periodicTablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(periodicTableLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(periodicTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startReactionButton)
                    .addComponent(newReactionButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(periodicTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchElementTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(addElementButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        labLabel.setFont(new java.awt.Font("Adwaita Sans", 0, 18)); // NOI18N
        labLabel.setText("Lab");

        chemistryLabel.setFont(new java.awt.Font("Adwaita Sans", 1, 36)); // NOI18N
        chemistryLabel.setText("Chemistry");

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chemistryLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chemistryLabel)
                    .addGroup(titlePanelLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(labLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        reactionInfoLabel.setFont(new java.awt.Font("Adwaita Sans", 1, 14)); // NOI18N
        reactionInfoLabel.setText("Reaction Info");

        productLabel.setText("Product");

        typeLabel.setText("Type");

        productInfoLabel.setText("Product Info");

        productInfoTextArea.setEditable(false);
        productInfoTextArea.setColumns(20);
        productInfoTextArea.setLineWrap(true);
        productInfoTextArea.setRows(5);
        productInfoTextArea.setWrapStyleWord(true);
        jScrollPane2.setViewportView(productInfoTextArea);

        productTextField.setEditable(false);

        typeTextField.setEditable(false);

        hazardLevelLabel.setText("Hazard Level");

        hazardTypeLabel.setText("Hazard Type");

        hazardInfoLabel.setText("Hazard Info");

        hazardTypeTextField.setEditable(false);

        hazardInfoTextArea.setEditable(false);
        hazardInfoTextArea.setColumns(20);
        hazardInfoTextArea.setLineWrap(true);
        hazardInfoTextArea.setRows(5);
        hazardInfoTextArea.setWrapStyleWord(true);
        jScrollPane3.setViewportView(hazardInfoTextArea);

        hazardLevelTextField.setEditable(false);

        javax.swing.GroupLayout reactionPanelLayout = new javax.swing.GroupLayout(reactionPanel);
        reactionPanel.setLayout(reactionPanelLayout);
        reactionPanelLayout.setHorizontalGroup(
            reactionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reactionPanelLayout.createSequentialGroup()
                .addGroup(reactionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(reactionPanelLayout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(reactionInfoLabel)
                        .addGap(0, 156, Short.MAX_VALUE))
                    .addGroup(reactionPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(reactionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(reactionPanelLayout.createSequentialGroup()
                                .addGroup(reactionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(productLabel)
                                    .addComponent(typeLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(reactionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(typeTextField)
                                    .addComponent(productTextField)))
                            .addGroup(reactionPanelLayout.createSequentialGroup()
                                .addComponent(productInfoLabel)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(reactionPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(reactionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(reactionPanelLayout.createSequentialGroup()
                                .addComponent(hazardInfoLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(reactionPanelLayout.createSequentialGroup()
                                .addComponent(hazardTypeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(hazardTypeTextField))
                            .addComponent(jScrollPane3)
                            .addGroup(reactionPanelLayout.createSequentialGroup()
                                .addComponent(hazardLevelLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(hazardLevelTextField)))))
                .addContainerGap())
        );
        reactionPanelLayout.setVerticalGroup(
            reactionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reactionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(reactionInfoLabel)
                .addGap(39, 39, 39)
                .addGroup(reactionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productLabel)
                    .addComponent(productTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(reactionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeLabel)
                    .addComponent(typeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(productInfoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(reactionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hazardLevelLabel)
                    .addComponent(hazardLevelTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(reactionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hazardTypeLabel)
                    .addComponent(hazardTypeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hazardInfoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3)
                .addContainerGap())
        );

        authorLabel.setText("Developed by: Lucas Fernandes");

        fileMenuList.setText("File");

        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(this::exitMenuItemActionPerformed);
        fileMenuList.add(exitMenuItem);

        menuBar.add(fileMenuList);

        helpMenuList.setText("Help");

        manualMenuItem.setText("Manual");
        manualMenuItem.addActionListener(this::manualMenuItemActionPerformed);
        helpMenuList.add(manualMenuItem);

        menuBar.add(helpMenuList);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(periodicTablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(reactionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(233, 233, 233))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(authorLabel)
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(reactionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(periodicTablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(authorLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addElementButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addElementButtonActionPerformed
        ChemicalElement selectedElement = periodicTableList.getSelectedValue();
        if (selectedElement == null) {
            JOptionPane.showMessageDialog(this, "Please select an element.");
            return;
        }

        if (!reactionController.canAddMoreElements()) {
            JOptionPane.showMessageDialog(this, "You can only add 2 elements per reaction.");
            return;
        }

        // Add element to reaction
        reactionController.addElement(selectedElement);
        productTextField.setText(reactionController.getCurrentReactionString());

        // Reset search field after selection
        searchElementTextField.setText("Search Element");
        searchElementTextField.setForeground(Color.GRAY);

        // Restore full element list
        populatePeriodicTableList(allElements);

        // Clear selection from JList
        periodicTableList.clearSelection();

    }//GEN-LAST:event_addElementButtonActionPerformed

    private void startReactionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startReactionButtonActionPerformed
    if (!reactionController.isReady()) {
        JOptionPane.showMessageDialog(this, "Add two elements to start a reaction!");
        return;
    }

    ChemicalReaction reaction = reactionController.startReaction();
    if (reaction == null) {
        JOptionPane.showMessageDialog(this, "Invalid reaction!");
    } else {
        productTextField.setText(reaction.getFirstElement() + " + " + reaction.getSecondElement() + " -> " + reaction.getProductName());
        typeTextField.setText(reaction.getReactionType());
        productInfoTextArea.setText(reaction.getDescription());
        hazardLevelTextField.setText(reaction.getHazardLevel());
        hazardTypeTextField.setText(reaction.getHazardType());
        hazardInfoTextArea.setText(reaction.getHazardInfo());

        // Set text color based on hazard level
        String hazardLevel = reaction.getHazardLevel();
        switch (hazardLevel) {
            case "No Hazard":
                hazardLevelTextField.setForeground(Color.decode("#4A90E2"));
                break;
            case "Low":
                hazardLevelTextField.setForeground(Color.decode("#4CAF50"));
                break;
            case "Moderate":
                hazardLevelTextField.setForeground(Color.decode("#FFD54F"));
                break;
            case "High":
                hazardLevelTextField.setForeground(Color.decode("#FF9800"));
                break;
            case "Extreme":
                hazardLevelTextField.setForeground(Color.decode("#F44336"));
                break;
            default:
                hazardLevelTextField.setForeground(Color.BLACK); // fallback
                break;
        }
        
                // --- Set text color based on hazard type (NEW) ---
        String hazardType = reaction.getHazardType();
        switch (hazardType) {
            case "Flammable":
                hazardTypeTextField.setForeground(Color.decode("#FF5722"));
                break;
            case "Explosive":
                hazardTypeTextField.setForeground(Color.decode("#E91E63"));
                break;
            case "Corrosive":
                hazardTypeTextField.setForeground(Color.decode("#9C27B0"));
                break;
            case "Toxic":
                hazardTypeTextField.setForeground(Color.decode("#4CAF50"));
                break;
            case "Irritant":
                hazardTypeTextField.setForeground(Color.decode("#FFC107"));
                break;
            case "Oxidizing":
                hazardTypeTextField.setForeground(Color.decode("#FF7043"));
                break;
            case "Environmental":
                hazardTypeTextField.setForeground(Color.decode("#009688"));
                break;
            case "No Hazard":
                hazardTypeTextField.setForeground(Color.decode("#4A90E2"));
                break;
            default:
                hazardTypeTextField.setForeground(Color.BLACK); // fallback
                break;
        }
    }
    }//GEN-LAST:event_startReactionButtonActionPerformed

    private void newReactionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newReactionButtonActionPerformed
        
        reactionController.reset();
        productTextField.setText("");
        typeTextField.setText("");
        productInfoTextArea.setText("");
        hazardLevelTextField.setText("");
        hazardTypeTextField.setText("");
        hazardInfoTextArea.setText("");
        periodicTableList.clearSelection();
    }//GEN-LAST:event_newReactionButtonActionPerformed

    private void manualMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manualMenuItemActionPerformed
    // Create a modal dialog using the current JFrame as parent
    JDialog manualDialog = new JDialog(this, "User Manual", false); // false = not modal
    manualDialog.setSize(500, 400);
    manualDialog.setLocationRelativeTo(this);

    // Use JTextArea inside JScrollPane for scrollable manual text
    JTextArea manualText = new JTextArea();
    manualText.setText(
        "Chemistry Lab Usage Manual:\n\n" +
        "1. To start a reaction, select two elements from the Periodic Table.\n" +
        "2. Search for elements by typing their symbol, double-click an element or click 'Add Element' to add it to the reaction.\n" +
        "3. Click 'Start Reaction' to see the resulting product, reaction type, and hazard info.\n" +
        "4. Use 'New Reaction' to clear the current selection and start over.\n\n" +
        "Ensure you only add two elements per reaction. Hazard levels and types are color-coded for safety.\n\n" + 
        
        "Some of the already implemented valid reactions: \n" +
        "H + O -> H2O \n" +
        "Na + Cl -> NaCl \n" +
        "N + O -> NO \n" +
        "Na + S -> NaS \n" +
        "H + Cl -> HCl \n" +
        "P + O -> PO \n\n" +

        "Currently 150 entries implemented on the database."
    );
    manualText.setEditable(false);
    manualText.setLineWrap(true);
    manualText.setWrapStyleWord(true);

    JScrollPane scrollPane = new JScrollPane(manualText);
    manualDialog.add(scrollPane);

    manualDialog.setVisible(true);
    }//GEN-LAST:event_manualMenuItemActionPerformed

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        this.dispose();
    }//GEN-LAST:event_exitMenuItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new ChemTable().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addElementButton;
    private javax.swing.JLabel authorLabel;
    private javax.swing.JLabel chemistryLabel;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenuList;
    private javax.swing.JLabel hazardInfoLabel;
    private javax.swing.JTextArea hazardInfoTextArea;
    private javax.swing.JLabel hazardLevelLabel;
    private javax.swing.JTextField hazardLevelTextField;
    private javax.swing.JLabel hazardTypeLabel;
    private javax.swing.JTextField hazardTypeTextField;
    private javax.swing.JMenu helpMenuList;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labLabel;
    private javax.swing.JMenuItem manualMenuItem;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JButton newReactionButton;
    private javax.swing.JLabel periodicTableLabel;
    private javax.swing.JList<ChemicalElement> periodicTableList;
    private javax.swing.JPanel periodicTablePanel;
    private javax.swing.JLabel productInfoLabel;
    private javax.swing.JTextArea productInfoTextArea;
    private javax.swing.JLabel productLabel;
    private javax.swing.JTextField productTextField;
    private javax.swing.JLabel reactionInfoLabel;
    private javax.swing.JPanel reactionPanel;
    private javax.swing.JTextField searchElementTextField;
    private javax.swing.JButton startReactionButton;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JLabel typeLabel;
    private javax.swing.JTextField typeTextField;
    // End of variables declaration//GEN-END:variables
}
