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
    private lateinit var colourPad: JLabel

    private lateinit var rSlider: JSlider
    private lateinit var rAddButton: JButton
    private lateinit var rMinusButton: JButton
    private lateinit var rText: JTextField

    private lateinit var gSlider: JSlider
    private lateinit var gAddButton: JButton
    private lateinit var gMinusButton: JButton
    private lateinit var gText: JTextField

    private lateinit var bSlider: JSlider
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
        title = "Kotlin Kolour Picker"
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

        colourPad = JLabel("#000000")
        colourPad.horizontalAlignment = SwingConstants.CENTER
        colourPad.bounds = Rectangle(20, 20, 260, 170)
        colourPad.font = defaultFont
        colourPad.isOpaque = true
        colourPad.background = Color(0,0,0)
        add(colourPad)

        //---R----------------------------------------------------------------------
        rAddButton = JButton("+")
        rAddButton.bounds = Rectangle(20,220,40,20)
        rAddButton.font = defaultFont
        rAddButton.addActionListener(this)     // Handle any clicks
        add(rAddButton)

        rSlider = JSlider(0, 255, 0)
        rSlider.bounds = Rectangle(10, 195, 100, 20)
        rSlider.addChangeListener {
            rText.text = rSlider.value.toString().format("%03d", rSlider.value)
            updateUI()
        }
        add(rSlider)

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

        gSlider = JSlider(0, 255, 0)
        gSlider.bounds = Rectangle(100, 195, 100, 20)
        gSlider.addChangeListener {
            gText.text = gSlider.value.toString()
            updateUI()
        }
        add(gSlider)

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

        bSlider = JSlider(0, 255, 0)
        bSlider.bounds = Rectangle(190, 195, 100, 20)
        bSlider.addChangeListener {
            bText.text = bSlider.value.toString()
            updateUI()
        }
        add(bSlider)

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

        var rVal = rText.text.toIntOrNull()?:0
        var gVal = gText.text.toIntOrNull()?:0
        var bVal = bText.text.toIntOrNull()?:0

        when (e?.source) {
            rAddButton -> rVal ++
            rMinusButton -> rVal --
            gAddButton -> gVal ++
            gMinusButton -> gVal --
            bAddButton -> bVal ++
            bMinusButton -> bVal --
        }
        rVal = (rVal + 256) %256
        gVal = (gVal + 256) %256
        bVal = (bVal + 256) %256

        rText.text = String.format("%03d", rVal)
        gText.text = String.format("%03d", gVal)
        bText.text = String.format("%03d", bVal)

        updateUI()
    }

    fun updateUI() {

        val r = rText.text.toIntOrNull()?:0
        val g = gText.text.toIntOrNull()?:0
        val b = bText.text.toIntOrNull()?:0

        val hexCode = String.format("#%02X%02X%02X", r, g, b)
        colourPad.text = hexCode
        colourPad.foreground = Color(255-r, 255-g, 255-b)
        colourPad.background = Color(r,g,b)

    }
}

