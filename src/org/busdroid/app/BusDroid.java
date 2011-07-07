package org.busdroid.app;

import android.app.Activity;
import android.os.Bundle;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;

public class BusDroid extends TabActivity implements TabHost.TabContentFactory {
    private static final int MENU_NEW_GAME = 0;
	private static final int MENU_QUIT = 0;
	private static final int MENU_SETTINGS = 0;

	/** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    final TabHost tabHost = getTabHost();        
    
    LayoutInflater.from(this).inflate(R.layout.tabs, tabHost.getTabContentView(), true );
    
    tabHost.addTab(tabHost.newTabSpec("tab1")
			.setIndicator("Localização", getResources().getDrawable(android.R.drawable.ic_dialog_map))
			.setContent(this));
    tabHost.addTab(tabHost.newTabSpec("tab2")
    		.setIndicator("Previsões", getResources().getDrawable(android.R.drawable.ic_dialog_info))
    		.setContent(this));
    tabHost.addTab(tabHost.newTabSpec("tab2")
    		.setIndicator("Meus Trajetos", getResources().getDrawable(android.R.drawable.ic_dialog_alert))
    		.setContent(this));
    }
    public View createTabContent(String tag) {
    	final TextView tv = new TextView(this);
    	tv.setText("Content for tab with tag "+ tag);
    	return tv;    	
    }
    /* Creates the menu items */
    public boolean onCreateOptionsMenu(Menu menu) {
 		menu.add(0, MENU_NEW_GAME, 0, "Doe");
 		menu.add(0, MENU_SETTINGS, 0, "Opções");
		menu.add(0, MENU_QUIT, 0, "Sobre");
        return true;
        
	}
}