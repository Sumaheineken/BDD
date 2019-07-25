package com.heineken.HAT.core.config;

/**
 * Created by mohana on 5/18/2019.
 */


    public class FileReaderManager {

        private static FileReaderManager fileReaderManager = new FileReaderManager();
        private static RuntimeConfiguration runtimeConfiguration;

        private FileReaderManager() {
        }

        public static FileReaderManager getInstance( ) {
            return fileReaderManager;
        }

        public RuntimeConfiguration getRuntimeConfiguration() {
            return (runtimeConfiguration == null) ? new RuntimeConfiguration() : runtimeConfiguration;
        }
    }




