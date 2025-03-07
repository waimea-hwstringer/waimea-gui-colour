/**
 * ===============================================================
 * Kotlin GUI Basic Starter
 * ===============================================================
 *
 * This is a starter project for a simple Kotlin GUI application.
 * The Java Swing library is used, plus the FlatLAF look-and-feel
 * for a reasonably modern look.
 */

import com.formdev.flatlaf.FlatDarkLaf
import java.awt.*
import java.awt.event.*
import javax.swing.*


/**
 * Launch the application
 */
fun main() {
    FlatDarkLaf.setup()     // Flat, dark look-and-feel
    MainWindow()            // Create and show the UI
}


/**
 * Main UI window (view)
 * Defines the UI and responds to events
 * The app model should be passwd as an argument
 */
class MainWindow : JFrame(), ActionListener {

    // Fields to hold the UI elements
    private lateinit var greetingLabel: JLabel


    private lateinit var rAddButton: JButton
    private lateinit var rMinusButton: JButton
    private lateinit var rText: JTextField

    private lateinit var gAddButton: JButton
    private lateinit var gMinusButton: JButton
    private lateinit var gText: JTextField

    private lateinit var bAddButton: JButton
    private lateinit var bMinusButton: JButton
    private lateinit var bText: JTextField


    /**
     * Configure the UI and display it
     */
    init {
        configureWindow()               // Configure the window
        addControls()                   // Build the UI

        setLocationRelativeTo(null)     // Centre the window
        isVisible = true                // Make it visible
    }

    /**
     * Configure the main window
     */
    private fun configureWindow() {
        title = "Kotlin Swing GUI Demo"
        contentPane.preferredSize = Dimension(300, 350)
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        isResizable = false
        layout = null

        pack()
    }

    /**
     * Populate the UI with UI controls
     */
    private fun addControls() {
        val defaultFont = Font(Font.SANS_SERIF, Font.PLAIN, 13)

        greetingLabel = JLabel("colour")
        greetingLabel.horizontalAlignment = SwingConstants.CENTER
        greetingLabel.bounds = Rectangle(20, 20, 240, 100)
        greetingLabel.font = defaultFont
        add(greetingLabel)

        //---R----------------------------------------------------------------------
        rAddButton = JButton("+")
        rAddButton.bounds = Rectangle(20,220,40,20)
        rAddButton.font = defaultFont
        rAddButton.addActionListener(this)     // Handle any clicks
        add(rAddButton)

        rMinusButton = JButton("-")
        rMinusButton.bounds = Rectangle(60,220,40,20)
        rMinusButton.font = defaultFont
        rMinusButton.addActionListener(this)     // Handle any clicks
        add(rMinusButton)

        rText = JTextField("000")
        rText.horizontalAlignment = SwingConstants.CENTER
        rText.addActionListener(this)
        rText.bounds = Rectangle(20, 250, 80, 80)
        rText.font = defaultFont
        rText.foreground = Color.red
        add(rText)

        //---G----------------------------------------------------------------------
        gAddButton = JButton("+")
        gAddButton.bounds = Rectangle(110,220,40,20)
        gAddButton.font = defaultFont
        gAddButton.addActionListener(this)     // Handle any clicks
        add(gAddButton)

        gMinusButton = JButton("-")
        gMinusButton.bounds = Rectangle(150,220,40,20)
        gMinusButton.font = defaultFont
        gMinusButton.addActionListener(this)     // Handle any clicks
        add(gMinusButton)

        gText = JTextField("000")
        gText.horizontalAlignment = SwingConstants.CENTER
        gText.addActionListener(this)
        gText.bounds = Rectangle(110, 250, 80, 80)
        gText.font = defaultFont
        gText.foreground = Color.green
        add(gText)

        //---B----------------------------------------------------------------------
        bAddButton = JButton("+")
        bAddButton.bounds = Rectangle(200,220,40,20)
        bAddButton.font = defaultFont
        bAddButton.addActionListener(this)     // Handle any clicks
        add(bAddButton)

        bMinusButton = JButton("-")
        bMinusButton.bounds = Rectangle(240,220,40,20)
        bMinusButton.font = defaultFont
        bMinusButton.addActionListener(this)     // Handle any clicks
        add(bMinusButton)

        bText = JTextField("000")
        bText.horizontalAlignment = SwingConstants.CENTER
        bText.addActionListener(this)
        bText.bounds = Rectangle(200, 250, 80, 80)
        bText.font = defaultFont
        bText.foreground = Color.blue
        add(bText)

    }


    /**
     * Handle any UI events (e.g. button clicks)
     */
    override fun actionPerformed(e: ActionEvent?) {
        when (e?.source) {
            rAddButton -> {
                greetingLabel.text = "red+++"
            }
        }
    }

}

