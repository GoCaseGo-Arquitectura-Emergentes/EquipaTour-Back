#!/bin/bash

# Especifica la ruta de la carpeta general que contiene los proyectos
carpeta_general="D:/UPC/TP1/core-service/"

# Carpetas a excluir
carpetas_excluir=("consensus-aggregate" "consensus-release-v2" "consensus-security" "eks")

# Obtén una lista de todos los directorios de primer nivel en la carpeta general
proyectos=$(find "$carpeta_general" -maxdepth 1 -type d)

git config --global credential.helper cache
# Recorre cada proyecto y realiza los cambios de rama
for proyecto in $proyectos; do
  if [[ -d "$proyecto/.git" ]]; then

    # Extrae el nombre de la carpeta del proyecto
    nombre_proyecto=$(basename "$proyecto")

    # Verifica si el nombre de la carpeta está en la lista de carpetas a excluir
    if [[ " ${carpetas_excluir[*]} " == *" $nombre_proyecto "* ]]; then
      echo "Excluyendo proyecto: $proyecto"
      continue
    fi

    echo "Procesando proyecto: $proyecto"
    cd "$proyecto"
    # Cambia a la rama base deseada y realiza el pull
    # git config --global user.name "ecortez"
    # git config --global user.email "ecortez@bytesw.com.pe"
    # ----------- PULLEAR -----------
    # git fetch origin
    # git remote -v
    # git pull origin dev-cpp-sp2
    # git pull
    # git pull --rebase
    # -------- CAMBIAR RAMA ---------
    git fetch
    git switch swat-develop
    git pull
    # --------- CREAR RAMA ----------
    # git switch -c dev-ttc-e0
    # git push origin -u dev-ttc-e0
    # ---------- BORRAR RAMA --------
    # git push origin :dev-cpp-sp2.ec
    # git branch -d dev-cpp-sp2.ec
    # cd .git
    # ----------- VER LINK ----------
    # git remote -v
    # ----- VER ULTIMO PROYECTO ------
    # git log --all --decorate --oneline --graph
    # ------- LIMPIAR PROYECTO -------
    # git gc --prune=now
    # git remote prune origin
    # git update-ref -d refs/remotes/origin/dev-cpp-sp2.ec
    cd ..
    echo "Proyecto completado: $proyecto"
    # echo "------------------------"
  fi
done
