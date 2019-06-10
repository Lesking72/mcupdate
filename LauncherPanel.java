package net.minecraft.launcher.ui;

import com.mojang.launcher.OperatingSystem;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import net.minecraft.launcher.Launcher;
import net.minecraft.launcher.LauncherConstants;
import net.minecraft.launcher.ui.tabs.LauncherTabPanel;
import net.minecraft.launcher.ui.tabs.WebsiteTab;
import org.apache.commons.lang3.SystemUtils;

public class LauncherPanel
extends JPanel
{
public static final String CARD_DIRT_BACKGROUND = "loading";
public static final String CARD_LOGIN = "login";
public static final String CARD_LAUNCHER = "launcher";
private final CardLayout cardLayout;
private final LauncherTabPanel tabPanel;
private final BottomBarPanel bottomBar;
private final JProgressBar progressBar;
private final Launcher minecraftLauncher;
private final JPanel loginPanel;
private JLabel warningLabel;

public LauncherPanel(Launcher minecraftLauncher)
{
this.minecraftLauncher = minecraftLauncher;
this.cardLayout = new CardLayout();
setLayout(this.cardLayout);

this.progressBar = new JProgressBar();
this.bottomBar = new BottomBarPanel(minecraftLauncher);
this.tabPanel = new LauncherTabPanel(minecraftLauncher);
this.loginPanel = new TexturedPanel("/dirt.png");
createInterface();
}

protected void createInterface()
{
add(createLauncherInterface(), "launcher");
add(createDirtInterface(), "loading");
add(createLoginInterface(), "login");
}

protected JPanel createLauncherInterface()
{
JPanel result = new JPanel(new BorderLayout());

this.tabPanel.getBlog().setPage("https://lesking72.github.io/mcupdate"); //replace original blog with mine

boolean javaBootstrap = getMinecraftLauncher().getBootstrapVersion().intValue() < 100;
boolean upgradableOS = OperatingSystem.getCurrentPlatform() == OperatingSystem.WINDOWS;
if (OperatingSystem.getCurrentPlatform() == OperatingSystem.OSX)
{
String ver = SystemUtils.OS_VERSION;
if ((ver != null) && (!ver.isEmpty()))
{
String[] split = ver.split("\\.", 3);
if (split.length >= 2) {
try
{
int major = Integer.parseInt(split[0]);
int minor = Integer.parseInt(split[1]);
if (major == 10) {
upgradableOS = minor >= 8;
} else if (major > 10) {
upgradableOS = true;
}
}
catch (NumberFormatException localNumberFormatException) {}
}
}
}
if ((javaBootstrap) && (upgradableOS))
{
this.warningLabel = new JLabel();
this.warningLabel.setForeground(Color.RED);
this.warningLabel.setHorizontalAlignment(0);
//URI url;
final URI url;
if (OperatingSystem.getCurrentPlatform() == OperatingSystem.WINDOWS) {
url = LauncherConstants.URL_UPGRADE_WINDOWS;
} else {
url = LauncherConstants.URL_UPGRADE_OSX;
}
if (SystemUtils.IS_JAVA_1_8)
{
/** Comment out code responsible for update nag
if (OperatingSystem.getCurrentPlatform() == OperatingSystem.WINDOWS) {
this.warningLabel.setText("<html><p style='font-size: 1.1em'>You are running an old version of the launcher. Please consider <a href='" + url + "'>using the new launcher</a> which will improve the performance of both launcher and game.</p></html>");
} else {
this.warningLabel.setText("<html><p style='font-size: 1em'>You are running an old version of the launcher. Please consider <a href='" + url + "'>using the new launcher</a> which will improve the performance of both launcher and game.</p></html>");
}
**/
}
else if (OperatingSystem.getCurrentPlatform() == OperatingSystem.WINDOWS) {
this.warningLabel.setText("<html><p style='font-size: 1.1em'>You are running on an old version of Java. Please consider <a href='" + url + "'>using the new launcher</a> which doesn't require Java, as it will make your game faster.</p></html>");
} else {
this.warningLabel.setText("<html><p style='font-size: 1em'>You are running on an old version of Java. Please consider <a href='" + url + "'>using the new launcher</a> which doesn't require Java, as it will make your game faster.</p></html>");
}
result.add(this.warningLabel, "North");
result.addMouseListener(new MouseAdapter()
{
public void mouseClicked(MouseEvent e)
{
OperatingSystem.openLink(url);
}
});
}
JPanel center = new JPanel();
center.setLayout(new BorderLayout());
center.add(this.tabPanel, "Center");
center.add(this.progressBar, "South");

this.progressBar.setVisible(false);
this.progressBar.setMinimum(0);
this.progressBar.setMaximum(100);
this.progressBar.setStringPainted(true);

result.add(center, "Center");
result.add(this.bottomBar, "South");

return result;
}

protected JPanel createDirtInterface()
{
return new TexturedPanel("/dirt.png");
}

protected JPanel createLoginInterface()
{
this.loginPanel.setLayout(new GridBagLayout());
return this.loginPanel;
}

public LauncherTabPanel getTabPanel()
{
return this.tabPanel;
}

public BottomBarPanel getBottomBar()
{
return this.bottomBar;
}

public JProgressBar getProgressBar()
{
return this.progressBar;
}

public Launcher getMinecraftLauncher()
{
return this.minecraftLauncher;
}

public void setCard(String card, JPanel additional)
{
if (card.equals("login"))
{
this.loginPanel.removeAll();
this.loginPanel.add(additional);
}
this.cardLayout.show(this, card);
}
}