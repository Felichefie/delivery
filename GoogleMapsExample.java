import org.jdesktop.swingx.JXMapViewer;
import org.jdesktop.swingx.mapviewer.GeoPosition;
import org.jdesktop.swingx.mapviewer.Waypoint;
import org.jdesktop.swingx.mapviewer.WaypointPainter;
import org.jdesktop.swingx.mapviewer.layers.Layer;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;

public class GoogleMapsExample extends JFrame {

    public GoogleMapsExample() {
        setTitle("MapViewer Example");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JXMapViewer mapViewer = new JXMapViewer();
        mapViewer.setZoom(7);

        GeoPosition initialPosition = new GeoPosition(37.7749, -122.4194); // San Francisco coordinates
        mapViewer.setAddressLocation(initialPosition);

        WaypointPainter<Waypoint> waypointPainter = new WaypointPainter<>();
        Waypoint waypoint = new Waypoint(initialPosition);
        waypointPainter.setWaypoints(Collections.singletonList(waypoint));

        mapViewer.setOverlayPainter(waypointPainter);

        getContentPane().add(mapViewer, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MapViewerExample example = new MapViewerExample();
            example.setVisible(true);
        });
    }
}
