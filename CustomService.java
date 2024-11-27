package service;

public class CustomService {

    public CustomMap processCustomData(CustomMap inputData) {
        CustomMap outputData = new CustomMap();
        String directoryPath = inputData.getCustomMap("configMap").getStr("directoryPath");
        
        if (!directoryPath.equals("")) {
            fetchCustomData(inputData, outputData);
            CustomMap customData = Beans.getDAO().selectCustomMap(directoryPath + ".customData", inputData);
            customData.put("session", inputData.get("session"));
            processFileList(customData, customData, outputData);
            calculateTargetCount(inputData, customData, customData);
            retrieveCustomDataList(inputData, customData, outputData);
            outputData.put("customData", customData);
            outputData.put("columns", getColumnList(inputData, "customData"));
            outputData.put("settings", settings);
        }
        
        outputData.put("inputData", inputData);
        return outputData;
    }

    public CustomMap fetchCustomData(CustomMap inputData, CustomMap outputData) {
        CustomMap printMap = inputData.getCustomMap("configMap").getCustomMap("printMap");
        if (printMap != null) {
            String[] printKeys = printMap.keyNames();
            if (printKeys != null && printKeys.length > 0) {
                for (int i = 0; i < printKeys.length; i++) {
                    if (printKeys[i].contains(getSettings().getStr("aDCustomData"))) {
                        CustomMap params = new CustomMap();
                        params.putAll(inputData);
                        params.put("sequence", inputData.getStr("printSequence"));
                        CustomMap printInfo = Beans.getDAO().selectCustomMap(printMap.getStr(printKeys[i]) + ".customData", params);
                        processFileList(printInfo, printInfo, printInfo);
                        outputData.put(printKeys[i], printInfo);
                    }
                }
            }
        }
        return outputData;
    }

    public CustomMap processFileList(CustomMap inputData, CustomMap customData) {
        return processFileList(inputData, customData, null);
    }

    public CustomMap processFileList(CustomMap inputData, CustomMap customData, CustomMap outputData) {
        String[] keyNames = inputData.keyNames();
        for (int i = 0; i < keyNames.length; i++) {
            if (keyNames[i].contains(getSettings().getStr("fileSearch"))) {
                if (outputData == null)
                    outputData = inputData;
                List<CamelMap> fileList = cmFileService.getFileList(customData.getInt(keyNames[i]));
                outputData.put(keyNames[i] + "Files", fileList);
                if (fileList != null && fileList.size() > 0) {
                    outputData.put(keyNames[i] + "CustomData", fileList.get(0));
                }
            }
        }
        return outputData;
    }

    public CustomMap calculateTargetCount(CustomMap inputData, CustomMap customData, CustomMap outputData) {
        if (inputData.getCustomMap("configMap").getStr("targetCountEnabled").equals("Y")) {
            CustomMap params = new CustomMap();
            params.put("tableName", inputData.getCustomMap("configMap").getStr("tableName"));
            params.put("session", inputData.getCustomMap("session"));
            params.put("sequence", customData.getStr("sequence"));
            params.put("targetOrgzCheck", inputData.getStr("targetOrgzCheck"));
            params.put("targetAppCheck", inputData.getStr("targetAppCheck"));
            params.put("targetAppCheckNumber", inputData.getStr("targetAppCheckNumber"));
            outputData.put("targetCount", Beans.getDAO().selectOne("custom.repository.targetCount", params));
        }
        return outputData;
    }

    public CustomMap retrieveCustomDataList(CustomMap inputData, CustomMap customData, CustomMap outputData) {
        CustomMap changeMap = inputData.getCustomMap("configMap").getCustomMap("changeMap");
        if (changeMap != null) {
            String[] changeKeys = changeMap.keyNames();
            if (changeKeys != null && changeKeys.length > 0) {
                for (int i = 0; i < changeKeys.length; i++) {
                    if (changeKeys[i].contains(getSettings().getStr("list"))) {
                        customData.put("session", inputData.getCustomMap("session"));
                        if (!customData.containsKey("configMap"))
                            customData.put("configMap", inputData.getCustomMap("configMap"));
                        if (!customData.containsKey("groupType"))
                            customData.put("groupType", changeKeys[i]);
                        List<CustomMap> dataList = Beans.getDAO().selectCustomMapList(changeMap.getStr(changeKeys[i]) + ".list", customData);
                        for (int j = 0; j < dataList.size(); j++) {
                            CustomMap map = dataList.get(j);
                            if (map.getStr("status").equals("")) {
                                map.put("status", TransactionTypes.UPDATED);
                            }
                            processFileList(map, map, map);
                        }
                        outputData.put(changeKeys[i], dataList);
                    }
                }
            }
        }
        return outputData;
    }
}
