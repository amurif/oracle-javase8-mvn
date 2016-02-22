package recipe5;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by O26 on 22/02/2016.
 */
public class EnvironmentVariable {

    Map<String, String> vars;

    public EnvironmentVariable() {
        vars = System.getenv();
    }

    public List<String> readAllEnvVariables(Map<String, String> vars) {
        List<String> result = new ArrayList<>();
        for (String var : vars.keySet()) {
            result.add(vars.get(var));
        }
        return result;
    }

    public Map<String, String> getVars() {
        return vars;
    }
}
