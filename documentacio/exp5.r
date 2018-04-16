par(mfrow=c(1,2))

a <- c(2222,5894,18672,45674,95380,175157,368280)
barplot(a/1000, xlab = "Valor de k (cantidad_de_grupos = 50*k)",
        main="Aumentando grupos",
        ylab = "Tiempo (s)",
        ylim=c(0,400),
        names.arg = c("1", "2", "3", "4", "5", "6", "7"),
        col="skyblue")


b <- c(1287,1278,1651,1665,1855,1967, 2206, 2513,2648, 2707, 2958, 3022, 3053, 3231, 3542,4002, 3733, 4114, 4143, 3957, 4220, 4232, 4336, 4660, 4738)
barplot(b/1000, xlab = "Valor de k (cantidad_de_centros = 5*k)",
        main="Aumentando centros",
        ylab = "Tiempo (s)",
        ylim=c(0,5),
        names.arg = c("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23","24", "25"),
        col="skyblue")
