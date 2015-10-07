package de.vogel612.swing;

import de.vogel612.swing.internal.SwingWrapperEnum;
import de.vogel612.swing.reflection.ThinWrapper;

import javax.accessibility.Accessible;
import javax.accessibility.AccessibleContext;
import javax.swing.*;
import javax.swing.plaf.OptionPaneUI;
import java.awt.*;

/**
 * Created by vogel612 on 07.10.15.
 */
@SuppressWarnings("unused")
@ThinWrapper(field = "wrapped", type = JComponent.class)
public class OptionPane extends JComponent implements Accessible {

    public enum Choice implements SwingWrapperEnum {
        OK(JOptionPane.OK_OPTION),
        CANCEL(JOptionPane.CANCEL_OPTION),
        YES(JOptionPane.YES_OPTION),
        NO(JOptionPane.NO_OPTION),
        CLOSED(JOptionPane.CLOSED_OPTION);

        private final int swingConstant;

        Choice(int swingConstant) {
            this.swingConstant = swingConstant;
        }

        @Override
        public int getSwingConstant() {
            return swingConstant;
        }

        public static Choice fromSwingConstant(int constant) {
            for (Choice v : values()) {
                if (v.swingConstant == constant) {
                    return v;
                }
            }
            return null;
        }
    }

    public enum OptionCombination implements SwingWrapperEnum {
        YES_NO_CANCEL(JOptionPane.YES_NO_CANCEL_OPTION),
        YES_NO(JOptionPane.YES_NO_OPTION),
        OK_CANCEL(JOptionPane.OK_CANCEL_OPTION),
        DEFAULT(JOptionPane.DEFAULT_OPTION);

        private final int swingConstant;

        OptionCombination(int swingConstant) {
            this.swingConstant = swingConstant;
        }

        @Override
        public int getSwingConstant() {
            return swingConstant;
        }

        public static OptionCombination fromSwingConstant(int constant) {
            for (OptionCombination v : values()) {
                if (v.swingConstant == constant) {
                    return v;
                }
            }
            return null;
        }
    }

    public enum MessageType implements SwingWrapperEnum {
        ERROR(JOptionPane.ERROR_MESSAGE),
        INFORMATION(JOptionPane.INFORMATION_MESSAGE),
        WARNING(JOptionPane.WARNING_MESSAGE),
        QUESTION(JOptionPane.QUESTION_MESSAGE),
        PLAIN(JOptionPane.PLAIN_MESSAGE);

        private final int swingConstant;

        MessageType(int swingConstant) {
            this.swingConstant = swingConstant;
        }

        @Override
        public int getSwingConstant() {
            return swingConstant;
        }

        public static MessageType fromSwingConstant(int constant) {
            for (MessageType v : values()) {
                if (v.swingConstant == constant) {
                    return v;
                }
            }
            return null;
        }
    }

    public static Choice showConfirmDialog(Component component, Object message) {
        return showConfirmDialog(component, message, "Select an Option", OptionCombination.YES_NO_CANCEL);
    }

    public static Choice showConfirmDialog(Component component, Object message, String title,
      OptionCombination combination) {
        return Choice.fromSwingConstant(JOptionPane.showConfirmDialog(component,
          message,
          title,
          combination.getSwingConstant()));
    }

    public static Choice showConfirmDialog(Component component, Object message, String title,
      OptionCombination combination, MessageType type) {
        return Choice.fromSwingConstant(JOptionPane.showConfirmDialog(component,
          message,
          title,
          combination.getSwingConstant(),
          type.getSwingConstant()));
    }

    public static Choice showConfirmDialog(Component component, Object message, String title,
      OptionCombination combination, MessageType type, Icon icon) {
        return Choice.fromSwingConstant(JOptionPane.showConfirmDialog(component,
          message,
          title,
          combination.getSwingConstant(),
          type.getSwingConstant(),
          icon));
    }

    public static String showInputDialog(Component parent, Object message) {
        return JOptionPane.showInputDialog(parent, message);
    }

    public static String showInputDialog(Component parent, Object message, Object initialSelectionValue) {
        return JOptionPane.showInputDialog(parent, message, initialSelectionValue);
    }

    public static String showInputDialog(Component parent, Object message, String title, MessageType type) {
        return JOptionPane.showInputDialog(parent, message, title, type.getSwingConstant());
    }

    public static Object showInputDialog(Component parent, Object message, String title, MessageType type, Icon icon,
      Object[] options, Object initialSelectionValue) {
        return JOptionPane.showInputDialog(parent,
          message,
          title,
          type.getSwingConstant(),
          icon,
          options,
          initialSelectionValue);
    }

    public static void showMessageDialog(Component parent, Object message) {
        JOptionPane.showMessageDialog(parent, message);
    }

    public static void showMessageDialog(Component parent, Object message, String title, MessageType type) {
        JOptionPane.showMessageDialog(parent, message, title, type.getSwingConstant());
    }

    public static void showMessageDialog(Component parent, Object message, String title, MessageType type, Icon icon) {
        JOptionPane.showMessageDialog(parent, message, title, type.getSwingConstant(), icon);
    }

    public static int showOptionDialog(Component parentComponent, Object message, String title,
      OptionCombination optionType, MessageType messageType, Icon icon, Object[] options, Object initialValue) {
        return JOptionPane.showOptionDialog(parentComponent,
          message,
          title,
          optionType.getSwingConstant(),
          messageType.getSwingConstant(),
          icon,
          options,
          initialValue);
    }

    public static void showInternalMessageDialog(Component parent, Object message) {
        showInternalMessageDialog(parent, message, "Message", MessageType.INFORMATION);
    }

    public static void showInternalMessageDialog(Component parent, Object message, String title, MessageType type) {
        JOptionPane.showInternalMessageDialog(parent, message, title, type.getSwingConstant());
    }

    public static void showInternalMessageDialog(Component parent, Object message, String title, MessageType type,
      Icon icon) {
        JOptionPane.showInternalMessageDialog(parent, message, title, type.getSwingConstant(), icon);
    }

    public static Choice showInternalConfirmDialog(Component parent, Object message) {
        return showInternalConfirmDialog(parent, message, "Select an Option", OptionCombination.YES_NO_CANCEL);
    }

    public static Choice showInternalConfirmDialog(Component parent, Object message, String title,
      OptionCombination options) {
        return Choice.fromSwingConstant(JOptionPane.showInternalConfirmDialog(parent,
          message,
          title,
          options.getSwingConstant()));
    }

    public static Choice showInternalConfirmDialog(Component parent, Object message, String title,
      OptionCombination options, MessageType type) {
        return Choice.fromSwingConstant(JOptionPane.showInternalConfirmDialog(parent,
          message,
          title,
          options.getSwingConstant(),
          type.getSwingConstant()));
    }

    public static Choice showInternalConfirmDialog(Component parent, Object message, String title,
      OptionCombination options, MessageType type, Icon icon) {
        return Choice.fromSwingConstant(JOptionPane.showInternalConfirmDialog(parent,
          message,
          title,
          options.getSwingConstant(),
          type.getSwingConstant(),
          icon));
    }

    public static int showInternalOptionDialog(Component parentComponent, Object message, String title,
      OptionCombination optionType, MessageType messageType, Icon icon, Object[] options, Object initialValue) {
        return JOptionPane.showInternalOptionDialog(parentComponent,
          message,
          title,
          optionType.getSwingConstant(),
          messageType.getSwingConstant(),
          icon,
          options,
          initialValue);
    }


    private final JOptionPane wrapped;

    public OptionPane(Object message) {
        this(message, MessageType.PLAIN);
    }

    public OptionPane(Object message, MessageType type) {
        this(message, type, OptionCombination.DEFAULT);
    }

    public OptionPane(Object message, MessageType type, OptionCombination options) {
        wrapped = new JOptionPane(message, type.getSwingConstant(), options.getSwingConstant());
    }

    public OptionPane(Object message, MessageType type, OptionCombination options, Icon icon) {
        wrapped = new JOptionPane(message, type.getSwingConstant(), options.getSwingConstant(), icon);
    }

    public OptionPane(Object message, MessageType type, OptionCombination combination, Icon icon, Object[] options) {
        wrapped = new JOptionPane(message, type.getSwingConstant(), combination.getSwingConstant(), icon, options);
    }

    public OptionPane(Object message, MessageType type, OptionCombination combination, Icon icon, Object[] options,
      Object initialSelection) {
        wrapped = new JOptionPane(message,
          type.getSwingConstant(),
          combination.getSwingConstant(),
          icon,
          options,
          initialSelection);
    }

    public JDialog createDialog(Component parent, String title) {
        return wrapped.createDialog(parent, title);
    }

    public JDialog createDialog(String title) {
        return wrapped.createDialog(title);
    }

    public JInternalFrame createInternalFrame(Component parent, String title) {
        return wrapped.createInternalFrame(parent, title);
    }

    @Override
    public AccessibleContext getAccessibleContext() {
        return wrapped.getAccessibleContext();
    }

    public static JDesktopPane getDesktopPaneForComponent(Component parent) {
        return JOptionPane.getDesktopPaneForComponent(parent);
    }

    public static Frame getFrameForComponent(Component parent) {
        return JOptionPane.getFrameForComponent(parent);
    }

    public Icon getIcon() {
        return wrapped.getIcon();
    }

    public Object getInitialSelectionValue() {
        return wrapped.getInitialSelectionValue();
    }

    public Object getInitialValue() {
        return wrapped.getInitialValue();
    }

    public Object getInputValue() {
        return wrapped.getInputValue();
    }

    public int getMaxCharactersPerLineCount() {
        return wrapped.getMaxCharactersPerLineCount();
    }

    public Object getMessage() {
        return wrapped.getMessage();
    }

    public MessageType getMessageType() {
        return MessageType.fromSwingConstant(wrapped.getMessageType());
    }

    public Object[] getOptions() {
        return wrapped.getOptions();
    }

    public OptionCombination getOptionType() {
        return OptionCombination.fromSwingConstant(wrapped.getOptionType());
    }

    public static Frame getRootFrame() {
        return JOptionPane.getRootFrame();
    }

    public Object[] getSelectionValues() {
        return wrapped.getSelectionValues();
    }

    public OptionPaneUI getUI() {
        return wrapped.getUI();
    }

    @Override
    public String getUIClassID() {
        return wrapped.getUIClassID();
    }

    public Object getValue() {
        return wrapped.getValue();
    }

    public boolean getWantsInput() {
        return wrapped.getWantsInput();
    }

    public void selectInitialValue() {
        wrapped.selectInitialValue();
    }

    public void setIcon(Icon icon) {
        wrapped.setIcon(icon);
    }

    public void setInialSelectionValue(Object newValue) {
        wrapped.setInitialSelectionValue(newValue);
    }

    public void setInialValue(Object val) {
        wrapped.setInitialValue(val);
    }

    public void setInputValue(Object val) {
        wrapped.setInputValue(val);
    }

    public void setMessage(Object msg) {
        wrapped.setMessage(msg);
    }

    public void setMessageType(MessageType type) {
        wrapped.setMessageType(type.getSwingConstant());
    }

    public void setOptions(Object[] opts) {
        wrapped.setOptions(opts);
    }

    public void setOptionType(OptionCombination combo) {
        wrapped.setOptionType(combo.getSwingConstant());
    }

    public static void setRootFrame(Frame newRoot) {
        JOptionPane.setRootFrame(newRoot);
    }

    public void setSelectionValues(Object[] newValues) {
        wrapped.setSelectionValues(newValues);
    }

    public void setUI(OptionPaneUI ui) {
        wrapped.setUI(ui);
    }

    public void setValue(Object newVal) {
        wrapped.setValue(newVal);
    }

    public void setWantsInput(boolean newValue) {
        wrapped.setWantsInput(newValue);
    }

    @Override
    public void updateUI() {
        wrapped.updateUI();
    }

    // FIXME delegate extended methods to wrapped object
}
