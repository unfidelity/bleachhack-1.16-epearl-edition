package bleach.hack.module;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import bleach.hack.event.events.EventKeyPress;
import bleach.hack.module.mods.*;
import com.google.common.eventbus.Subscribe;

public class ModuleManager {

	private static List<Module> mods = Arrays.asList(
			new Ambience(),
			new AutoTotem(),
			new ChestESP(),
			new ClickGui(),
			new Criticals(),
			new CrystalAura(),
			new ElytraFly(),
			new EntitySpeed(),
			new ESP(),
			new FastUse(),
			new Flight(),
			new Freecam(),
			new Fullbright(),
			new Jesus(),
			new Killaura(),
			new Nametags(),
			new Nofall(),
			new NoSlow(),
			new Notebot(),
			new NotebotStealer(),
			new NoVelocity(),
			new OffhandCrash(),
			new PacketFly(),
			new Peek(),
			new Scaffold(),
			new Spammer(),
			new Speed(),
			new SpeedMine(),
			new Sprint(),
			new StarGithubPls(),
			new Step(),
			new Tracers(),
			new Trail(),
			new UI());
	
	public static List<Module> getModules() {
		return mods;
	}

	public static Module getModule(Class<?extends Module> clazz) {
		for(Module module : mods) {
			if(module.getClass().equals(clazz)) {
				return module;
			}
		}

		return null;
	}

	public static Module getModuleByName(String name) {
	    for (Module m: mods) {
	        if (name.equals(m.getName())) return m;
	    }
	    return null;
	}
	
	public static List<Module> getModulesInCat(Category cat) {
		List<Module> mds = new ArrayList<>();
	    for (Module m: mods) {
	        if (m.getCategory().equals(cat)) mds.add(m);
	    }
	    return mds;
	}

	@Subscribe
	public static void handleKeyPress(EventKeyPress eventKeyPress) {
		for (Module m : mods) {
			if (m.getKey() == eventKeyPress.getKey()) {
				m.toggle();
			}
		}
	}
}