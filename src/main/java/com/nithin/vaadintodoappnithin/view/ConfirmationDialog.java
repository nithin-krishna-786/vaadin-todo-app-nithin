package com.nithin.vaadintodoappnithin.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class ConfirmationDialog extends Dialog {

    public ConfirmationDialog(String title, String message, Runnable deleteAction) {
        // Set dialog title
        setHeaderTitle(title);

        // Create a label for the message
        Label messageLabel = new Label(message);
        add(messageLabel);
        
        HorizontalLayout hl = new HorizontalLayout();

        // Create "Delete" button
        Button deleteButton = new Button("Delete", e -> {
            deleteAction.run(); // Call the delete action
            close(); // Close the dialog
        });
        hl.add(deleteButton);

        // Create "Cancel" button (optional)
        Button cancelButton = new Button("Cancel", e -> close());
        hl.add(cancelButton);
        add(hl);
    }
}