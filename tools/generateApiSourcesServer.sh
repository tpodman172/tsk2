#!/usr/bin/env bash

TARGET_FILE_PATH="/Users/nakasetakaharu/uzomuzo/api/doc"
SERVER_FILE_PATH="/Users/nakasetakaharu/uzomuzo/server"
PACKAGE="com.tpodman172.uzomuzo.server.login"

PACKAGE_PATH=${PACKAGE} | tr '.' '/'

createApiGen() {
  docker run --rm \
    -v ${TARGET_FILE_PATH}:/local/document \
    -v ${SERVER_FILE_PATH}/src/generated/java/${PACKAGE_PATH}:/local/out/src/main/java/${PACKAGE_PATH} \
    openapitools/openapi-generator-cli:v3.3.4 \
    sh -c "rm -rf /local/out/src/main/java/${PACKAGE_PATH}* && \
    /usr/local/bin/docker-entrypoint.sh generate \
    -i /local/document/petstore.yaml \
    -g spring \
    -o /local/out \
    --additional-properties useTags=true \
    --additional-properties interfaceOnly=true \
    --additional-properties dateLibrary=java8 \
    --model-package ${PACKAGE}.appService.model \
    --api-package ${PACKAGE}.controller
    "
}

createApiGen