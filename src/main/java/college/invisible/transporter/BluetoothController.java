package college.invisible.transporter;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;

/* A singleton class.
 * @ppham created 1/14/2017.
 */
public class BluetoothController {

    private static BluetoothController singleton;

    private Activity mParentActivity;
    private Intent mDeviceScanIntent;

    /* Constructor for a singleton */
    private BluetoothController(Activity parentActivity) {
        mParentActivity = parentActivity;
        mDeviceScanIntent = new Intent(mParentActivity, DeviceScanActivity.class);
    }

    public void scanForDevices() {
        mParentActivity.startActivity(mDeviceScanIntent);
    }

    public static BluetoothController getInstance(Activity activity) {
        if (singleton == null) {
            singleton = new BluetoothController(activity);
        }
        return singleton;
    }

}