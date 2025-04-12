// errno.hb

// extern char*[] sys_errlist;
extern char *strerror(int errnum);
extern int sys_nerr;
extern int errno;
