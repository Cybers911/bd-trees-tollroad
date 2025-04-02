

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import static jdk.tools.jlink.internal.plugins.PluginsResourceBundle.getDescription;

/**
 * Application to demonstrate a TreeMap storing key:value pairs in sorted
 * order based on natural ordering of keys and also a different ordering
 * of the same keys based on the results of a Comparator.
 */
public class TollRoad {
    // TODO 1: Declare two Map variables to associate String keys with Vehicle objects.
    // TODO 1: One will sort by vehicle description and one will sort by vehicle state.
    private Map<String, Vehicle> vehicleByDescription;
    private Map<String, Vehicle> vehicleByState;



    /**
     * TollRoad constructor creates two TreeMaps to store data with
     * different keys. The second uses a Comparator to store based
     * on the state code of each vehicle.
     */
    public TollRoad() {
        // TODO 2: Create the two TreeMap objects, the second of which must be
        // TODO 2: given an appropriate Comparator object when constructed.
        vehicleByDescription = new TreeMap<>();
       //Create a Comparator for sorting by vehicle state
        Comparator<String> stateComparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.substring(1).compareTo(s2.substring(1));
            }
        };
        //Creating the second TreeMap with the
        // comparator to sort by state
        vehicleByState = new TreeMap<>(stateComparator);
        //Se crearon 2 treMaps uno para el caracter del tipo de vehiculo y el otro para los caracteres consecutivos
        // de el estado con el comparator para ordenar por estado



    }

    /**
     * Adds a toll with the given vehicle's description. If the vehicle has
     * already passed through a toll reader, its toll count is updated.
     * If this is the first time the vehicle has passed through a toll
     * reader, a new Vehicle object is created and added to the TreeMaps.
     *
     * @param description The Vehicle's description.
     */
    public void addToll(String description) {
        // TODO 3: Complete this method as described in the exercise.
        // Update the toll count if the vehicle has already passed through a toll reader,
        // otherwise create a new Vehicle object and add it to the TreeMaps.
        Vehicle vehicle = vehicleByDescription.get(description);
            if (vehicle == null) {// si el vehiculo no exixte creo un nuevo vehiculo y lo adhiero a los dos treeMaps,
                // uno para el tipo de carro y el otro para el estado con sus dos caracteres consecutivos
                vehicle = new Vehicle(description);
                 vehicleByDescription.put(description, vehicle);
                 vehicleByState.put(description, vehicle);
            } else {
                vehicle.addToll();//si el vehiculo ya esta en el TreeMap lo actualizo
                // en los dos treeMaps y sumo la cantidad de toll a los dos treeMaps
            }
    }

    /**
     * Builds and returns a String containing the current Vehicles
     * sorted by description.
     *
     * @return String containing the current vehicles, sorted by description.
     */

    /*public String getVehicleReportByDescription() {
        // TODO 4: Complete this method as described in the exercise.
        StringBuilder report = new StringBuilder();
        for (Map.Entry<String, Vehicle> entry : vehicleByDescription.entrySet()) {
            report.append("Description: ").append(entry.getKey())
                   .append(", Toll Count: ").append(entry.getValue().getTollCount())
                   .append("\n");
        }// Aqui aqui construyo el reporte con los vehiculos ordenados por descripcion
        return report.toString();*/ // devuelvo el reporte en formato string
        //explicando este metodo linea por linea que crea el reporte con los vehiculos ordenados por descripcion
        // en este caso creo el reporte con los vehiculos ordenados por descripcion, cada vehiculo se muestra
        //      con su descripcion y la cantidad de toll que ha recibido
        // en este caso lo hago para cada entry del TreeMap, que es cada vehiculo con su descripcion
        //  y la cantidad de toll que ha recibido
        //Explicar linea por linea de cosigo este metodo como una estructura de datos
        // en este caso creo un StringBuilder para poder ir añadiendo los strings
        // en cada iteracion añado un string que contiene la descripcion del vehiculo y la cantidad de toll que ha recibido
        // al final devuelvo el StringBuilder como un string, que es el reporte en formato string
   // }
    public String getVehicleReportByDescription() {
        StringBuilder report = new StringBuilder();
        for (Vehicle vehicle : vehicleByDescription.values()) {
            report.append(String.format("Description: %s, Toll Count: %d\n",
                    vehicle.description, vehicle.tollCount));
        }
        return report.toString();
    }


    /**
     * Builds and returns a String containing the current Vehicles
     * sorted by state.
     *
     * @return String containing the current vehicles, sorted by state.
     */
    public String getVehicleReportByState() {
        // TODO 5: Complete this method as described in the exercise.
      StringBuilder report = new StringBuilder();
      for (Vehicle vehicle : vehicleByState.values()) {
          report.append(String.format("Description: %s, Toll Count: %d\n", vehicle.description, vehicle.tollCount));
      }
      return report.toString();
    }
    //ex
    // Este metodo es el que muestra el reporte con los vehiculos ordenados por estado
    // en este caso creo un StringBuilder para poder ir añadiendo los strings
    // en cada iteracion añado un string que contiene la descripcion del vehiculo y la cantidad de toll que ha recibido
    // al final devuelvo el StringBuilder como un string, que es el reporte en formato string
    // A donde estoy iterando en el TreeMap, que es cada vehiculo con su descripcion y la cantidad de toll que ha recibido
    // Cual es el treeMap y como saca la descripcion y la cantidad de toll de cada vehiculo,
    // esto es lo que hago para cada entry del TreeMap, que es cada vehiculo con su descripcion y la cantidad de toll que ha recibido


    /**
     * Main method to demonstrate the Toll Road and Vehicle classes.
     *
     * Expected output:
     *
     * Vehicle Tolls By Description:
     * Description: CCO123ABC, Toll Count: 2
     * Description: CIA432LMN, Toll Count: 3
     * Description: SFL456DEF, Toll Count: 2
     * Description: TCO789XYZ, Toll Count: 4
     * Description: TIA765QRS, Toll Count: 1
     *
     * Vehicle Tolls By State:
     * Description: CCO123ABC, Toll Count: 2
     * Description: TCO789XYZ, Toll Count: 4
     * Description: SFL456DEF, Toll Count: 2
     * Description: CIA432LMN, Toll Count: 3
     * Description: TIA765QRS, Toll Count: 1
     *
     * @param args Command line arguments; ignored in this application.
     */
    public static void main(String[] args) {
        // Create the TollRoad, add some test data, and show the results.
        TollRoad tollRoad = new TollRoad();
        tollRoad.addToll("CCO123ABC");
        tollRoad.addToll("CIA432LMN");
        tollRoad.addToll("TCO789XYZ");
        tollRoad.addToll("SFL456DEF");
        tollRoad.addToll("TCO789XYZ");
        tollRoad.addToll("CIA432LMN");
        tollRoad.addToll("TCO789XYZ");
        tollRoad.addToll("TIA765QRS");
        tollRoad.addToll("CCO123ABC");
        tollRoad.addToll("SFL456DEF");
        tollRoad.addToll("CIA432LMN");
        tollRoad.addToll("TCO789XYZ");

        System.out.println("Vehicle Tolls By Description:");
        System.out.println(tollRoad.getVehicleReportByDescription());

        System.out.println("Vehicle Tolls By State:");
        System.out.println(tollRoad.getVehicleReportByState());
    }
}
