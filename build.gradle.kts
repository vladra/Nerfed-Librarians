import net.minecrell.pluginyml.bukkit.BukkitPluginDescription



plugins {
    `java-library`
    id("io.papermc.paperweight.userdev") version "2.0.0-beta.17"
    id("de.eldoria.plugin-yml.bukkit") version "0.7.1"
}

group = "com.vladra.nerfed-librarians"
version = "1.0"
description = "Nerf librarians by removing enchanted book trades."

dependencies {
    paperweight.paperDevBundle("1.21.7-R0.1-SNAPSHOT")
    compileOnly("io.papermc.paper:paper-api:1.21.7-R0.1-SNAPSHOT")
    library("com.google.code.gson", "gson", "2.10.1")

}

tasks {
    assemble {
        dependsOn(reobfJar)
    }

    compileJava {
        options.encoding = Charsets.UTF_8.name()
        options.release.set(21) // updated

    }
    javadoc {
        options.encoding = Charsets.UTF_8.name()
    }
    processResources {
        filteringCharset = Charsets.UTF_8.name()
    }
}

bukkit {
    main = "com.vladra.nerfed-librarians.NerfedLibrarians"
    apiVersion = "1.21"
    author = "Vladra"
    }


paperweight {
paperweight.reobfArtifactConfiguration = io.papermc.paperweight.userdev.ReobfArtifactConfiguration.REOBF_PRODUCTION
}


