#include <stdio.h>
#include <sys/socket.h>

#include <string.h>
#include <arpa/inet.h> //vad är detta för?

#include <unistd.h> // so that close() will work. Thanks andersgs!


int main(int argc, char *argv[]){
    char message[] = "Datapaket från Rickard         !"; //message[32];

    struct sockaddr_in server_addr; //varför denna structen?
    int server_struct_length = sizeof(server_addr);

    int socket_desc;
    socket_desc = socket(AF_INET, SOCK_DGRAM, IPPROTO_UDP);/*0); /* First parameter is domain 
    AF_INET is IPV4, AF_INET6 for IPV6, AF_LOCAL for connections on the same host. 
    Second parameter is communication type SOCK_STREAM (TCP) is reliable,
    SOCK_DGRAM (UDP) is unreliable, just sends the packets. Third parameter is protocol */
    if(socket_desc == -1) {
        printf("Could not create socket!\n");
    }
    else{
        printf("Could create a socket!\n");
    }
    /*Setsockopt(int sockfd, int optname, const void *optval, socklen_t optlen)
    completely optional function but helps in reuse of address and port. Prevents errors 
    such as "address already in use"*/

    //Fortsättning följer
    server_addr.sin_family = AF_INET; //??
    server_addr.sin_port = htons(8887); //??
    server_addr.sin_addr.s_addr = inet_addr("192.168.1.2"); //??

    //message = "Datapaket från Rickard         !";

    if(sendto(socket_desc, message, strlen(message), 0, (struct sockaddr*)&server_addr, server_struct_length) < 0) {
        printf("Unable to send message :(\n");
        return -1;
    }
    close(socket_desc);
    printf("successfully sent message!\n");
    return 0;
}