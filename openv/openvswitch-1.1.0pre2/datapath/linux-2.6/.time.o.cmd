cmd_/users/stud16/openv/openvswitch-1.1.0pre2/datapath/linux-2.6/time.o :=  gcc-4.3 -Wp,-MD,/users/stud16/openv/openvswitch-1.1.0pre2/datapath/linux-2.6/.time.o.d  -nostdinc -isystem /usr/lib/gcc/i486-linux-gnu/4.3.5/include -I/users/stud16/openv/openvswitch-1.1.0pre2/datapath/linux-2.6/compat-2.6 -I/users/stud16/openv/openvswitch-1.1.0pre2/datapath/linux-2.6/compat-2.6/include  -Iinclude -Iinclude2 -I/usr/src/linux-headers-2.6.32-5-common/include -I/usr/src/linux-headers-2.6.32-5-common/arch/x86/include -include include/linux/autoconf.h   -I/users/stud16/openv/openvswitch-1.1.0pre2/datapath/linux-2.6 -D__KERNEL__ -Wall -Wundef -Wstrict-prototypes -Wno-trigraphs -fno-strict-aliasing -fno-common -Werror-implicit-function-declaration -Wno-format-security -fno-delete-null-pointer-checks -Os -m32 -msoft-float -mregparm=3 -freg-struct-return -mpreferred-stack-boundary=2 -march=i686 -mtune=generic -Wa,-mtune=generic32 -ffreestanding -fstack-protector -DCONFIG_AS_CFI=1 -DCONFIG_AS_CFI_SIGNAL_FRAME=1 -pipe -Wno-sign-compare -fno-asynchronous-unwind-tables -mno-sse -mno-mmx -mno-sse2 -mno-3dnow -fomit-frame-pointer -Wdeclaration-after-statement -Wno-pointer-sign -fno-strict-overflow -DVERSION=\"1.1.0pre2\"   -I/users/stud16/openv/openvswitch-1.1.0pre2/datapath/linux-2.6/..   -I/users/stud16/openv/openvswitch-1.1.0pre2/datapath/linux-2.6/..   -I/users/stud16/openv/openvswitch-1.1.0pre2/include -DBUILDNR=\"\" -g -include /users/stud16/openv/openvswitch-1.1.0pre2/datapath/linux-2.6/kcompat.h  -DMODULE -D"KBUILD_STR(s)=\#s" -D"KBUILD_BASENAME=KBUILD_STR(time)"  -D"KBUILD_MODNAME=KBUILD_STR(openvswitch_mod)"  -c -o /users/stud16/openv/openvswitch-1.1.0pre2/datapath/linux-2.6/.tmp_time.o /users/stud16/openv/openvswitch-1.1.0pre2/datapath/linux-2.6/time.c

deps_/users/stud16/openv/openvswitch-1.1.0pre2/datapath/linux-2.6/time.o := \
  /users/stud16/openv/openvswitch-1.1.0pre2/datapath/linux-2.6/time.c \
  /users/stud16/openv/openvswitch-1.1.0pre2/datapath/linux-2.6/kcompat.h \
  /usr/src/linux-headers-2.6.32-5-common/include/linux/time.h \
    $(wildcard include/config/arch/uses/gettimeoffset.h) \
  /users/stud16/openv/openvswitch-1.1.0pre2/datapath/linux-2.6/compat-2.6/include/linux/types.h \
  /usr/src/linux-headers-2.6.32-5-common/include/linux/types.h \
    $(wildcard include/config/uid16.h) \
    $(wildcard include/config/lbdaf.h) \
    $(wildcard include/config/phys/addr/t/64bit.h) \
    $(wildcard include/config/64bit.h) \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/types.h \
    $(wildcard include/config/x86/64.h) \
    $(wildcard include/config/highmem64g.h) \
  /usr/src/linux-headers-2.6.32-5-common/include/asm-generic/types.h \
  /usr/src/linux-headers-2.6.32-5-common/include/asm-generic/int-ll64.h \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/bitsperlong.h \
  /usr/src/linux-headers-2.6.32-5-common/include/asm-generic/bitsperlong.h \
  /usr/src/linux-headers-2.6.32-5-common/include/linux/posix_types.h \
  /users/stud16/openv/openvswitch-1.1.0pre2/datapath/linux-2.6/compat-2.6/include/linux/stddef.h \
  /usr/src/linux-headers-2.6.32-5-common/include/linux/stddef.h \
  /usr/src/linux-headers-2.6.32-5-common/include/linux/compiler.h \
    $(wildcard include/config/trace/branch/profiling.h) \
    $(wildcard include/config/profile/all/branches.h) \
    $(wildcard include/config/enable/must/check.h) \
    $(wildcard include/config/enable/warn/deprecated.h) \
  /usr/src/linux-headers-2.6.32-5-common/include/linux/compiler-gcc.h \
    $(wildcard include/config/arch/supports/optimized/inlining.h) \
    $(wildcard include/config/optimize/inlining.h) \
  /usr/src/linux-headers-2.6.32-5-common/include/linux/compiler-gcc4.h \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/posix_types.h \
    $(wildcard include/config/x86/32.h) \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/posix_types_32.h \
  /usr/src/linux-headers-2.6.32-5-common/include/linux/cache.h \
    $(wildcard include/config/smp.h) \
    $(wildcard include/config/arch/has/cache/line/size.h) \
  /users/stud16/openv/openvswitch-1.1.0pre2/datapath/linux-2.6/compat-2.6/include/linux/kernel.h \
  /usr/src/linux-headers-2.6.32-5-common/include/linux/kernel.h \
    $(wildcard include/config/preempt/voluntary.h) \
    $(wildcard include/config/debug/spinlock/sleep.h) \
    $(wildcard include/config/prove/locking.h) \
    $(wildcard include/config/printk.h) \
    $(wildcard include/config/dynamic/debug.h) \
    $(wildcard include/config/ring/buffer.h) \
    $(wildcard include/config/tracing.h) \
    $(wildcard include/config/numa.h) \
    $(wildcard include/config/ftrace/mcount/record.h) \
  /usr/lib/gcc/i486-linux-gnu/4.3.5/include/stdarg.h \
  /usr/src/linux-headers-2.6.32-5-common/include/linux/linkage.h \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/linkage.h \
    $(wildcard include/config/x86/alignment/16.h) \
  /usr/src/linux-headers-2.6.32-5-common/include/linux/stringify.h \
  /usr/src/linux-headers-2.6.32-5-common/include/linux/bitops.h \
    $(wildcard include/config/generic/find/first/bit.h) \
    $(wildcard include/config/generic/find/last/bit.h) \
    $(wildcard include/config/generic/find/next/bit.h) \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/bitops.h \
    $(wildcard include/config/x86/cmov.h) \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/alternative.h \
    $(wildcard include/config/paravirt.h) \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/asm.h \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/cpufeature.h \
    $(wildcard include/config/x86/invlpg.h) \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/required-features.h \
    $(wildcard include/config/x86/minimum/cpu/family.h) \
    $(wildcard include/config/math/emulation.h) \
    $(wildcard include/config/x86/pae.h) \
    $(wildcard include/config/x86/cmpxchg64.h) \
    $(wildcard include/config/x86/use/3dnow.h) \
    $(wildcard include/config/x86/p6/nop.h) \
  /usr/src/linux-headers-2.6.32-5-common/include/asm-generic/bitops/sched.h \
  /usr/src/linux-headers-2.6.32-5-common/include/asm-generic/bitops/hweight.h \
  /usr/src/linux-headers-2.6.32-5-common/include/asm-generic/bitops/fls64.h \
  /usr/src/linux-headers-2.6.32-5-common/include/asm-generic/bitops/ext2-non-atomic.h \
  /usr/src/linux-headers-2.6.32-5-common/include/asm-generic/bitops/le.h \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/byteorder.h \
  /usr/src/linux-headers-2.6.32-5-common/include/linux/byteorder/little_endian.h \
  /usr/src/linux-headers-2.6.32-5-common/include/linux/swab.h \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/swab.h \
    $(wildcard include/config/x86/bswap.h) \
  /usr/src/linux-headers-2.6.32-5-common/include/linux/byteorder/generic.h \
  /usr/src/linux-headers-2.6.32-5-common/include/asm-generic/bitops/minix.h \
  /users/stud16/openv/openvswitch-1.1.0pre2/datapath/linux-2.6/compat-2.6/include/linux/log2.h \
  /usr/src/linux-headers-2.6.32-5-common/include/linux/log2.h \
    $(wildcard include/config/arch/has/ilog2/u32.h) \
    $(wildcard include/config/arch/has/ilog2/u64.h) \
  /usr/src/linux-headers-2.6.32-5-common/include/linux/typecheck.h \
  /usr/src/linux-headers-2.6.32-5-common/include/linux/ratelimit.h \
  /usr/src/linux-headers-2.6.32-5-common/include/linux/param.h \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/param.h \
  /usr/src/linux-headers-2.6.32-5-common/include/asm-generic/param.h \
    $(wildcard include/config/hz.h) \
  /usr/src/linux-headers-2.6.32-5-common/include/linux/dynamic_debug.h \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/bug.h \
    $(wildcard include/config/bug.h) \
    $(wildcard include/config/debug/bugverbose.h) \
  /users/stud16/openv/openvswitch-1.1.0pre2/datapath/linux-2.6/compat-2.6/include/asm-generic/bug.h \
  /usr/src/linux-headers-2.6.32-5-common/include/asm-generic/bug.h \
    $(wildcard include/config/generic/bug.h) \
    $(wildcard include/config/generic/bug/relative/pointers.h) \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/div64.h \
  include/linux/version.h \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/cache.h \
    $(wildcard include/config/x86/l1/cache/shift.h) \
    $(wildcard include/config/x86/vsmp.h) \
  /usr/src/linux-headers-2.6.32-5-common/include/linux/seqlock.h \
  /usr/src/linux-headers-2.6.32-5-common/include/linux/spinlock.h \
    $(wildcard include/config/debug/spinlock.h) \
    $(wildcard include/config/generic/lockbreak.h) \
    $(wildcard include/config/preempt.h) \
    $(wildcard include/config/debug/lock/alloc.h) \
  /usr/src/linux-headers-2.6.32-5-common/include/linux/preempt.h \
    $(wildcard include/config/debug/preempt.h) \
    $(wildcard include/config/preempt/tracer.h) \
    $(wildcard include/config/preempt/notifiers.h) \
  /usr/src/linux-headers-2.6.32-5-common/include/linux/thread_info.h \
    $(wildcard include/config/compat.h) \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/thread_info.h \
    $(wildcard include/config/debug/stack/usage.h) \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/page.h \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/page_types.h \
  /usr/src/linux-headers-2.6.32-5-common/include/linux/const.h \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/page_32_types.h \
    $(wildcard include/config/highmem4g.h) \
    $(wildcard include/config/page/offset.h) \
    $(wildcard include/config/4kstacks.h) \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/page_32.h \
    $(wildcard include/config/hugetlb/page.h) \
    $(wildcard include/config/debug/virtual.h) \
    $(wildcard include/config/flatmem.h) \
    $(wildcard include/config/x86/3dnow.h) \
  /usr/src/linux-headers-2.6.32-5-common/include/linux/string.h \
    $(wildcard include/config/binary/printf.h) \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/string.h \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/string_32.h \
    $(wildcard include/config/kmemcheck.h) \
  /usr/src/linux-headers-2.6.32-5-common/include/asm-generic/memory_model.h \
    $(wildcard include/config/discontigmem.h) \
    $(wildcard include/config/sparsemem/vmemmap.h) \
    $(wildcard include/config/sparsemem.h) \
  /usr/src/linux-headers-2.6.32-5-common/include/asm-generic/getorder.h \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/processor.h \
    $(wildcard include/config/cc/stackprotector.h) \
    $(wildcard include/config/m386.h) \
    $(wildcard include/config/m486.h) \
    $(wildcard include/config/x86/debugctlmsr.h) \
    $(wildcard include/config/cpu/sup/amd.h) \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/processor-flags.h \
    $(wildcard include/config/vm86.h) \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/vm86.h \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/ptrace.h \
    $(wildcard include/config/x86/ptrace/bts.h) \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/ptrace-abi.h \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/segment.h \
  /usr/src/linux-headers-2.6.32-5-common/include/linux/init.h \
    $(wildcard include/config/modules.h) \
    $(wildcard include/config/hotplug.h) \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/math_emu.h \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/sigcontext.h \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/current.h \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/percpu.h \
    $(wildcard include/config/x86/64/smp.h) \
  /usr/src/linux-headers-2.6.32-5-common/include/asm-generic/percpu.h \
    $(wildcard include/config/have/setup/per/cpu/area.h) \
  /usr/src/linux-headers-2.6.32-5-common/include/linux/threads.h \
    $(wildcard include/config/nr/cpus.h) \
    $(wildcard include/config/base/small.h) \
  /usr/src/linux-headers-2.6.32-5-common/include/linux/percpu-defs.h \
    $(wildcard include/config/debug/force/weak/per/cpu.h) \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/system.h \
    $(wildcard include/config/ia32/emulation.h) \
    $(wildcard include/config/x86/32/lazy/gs.h) \
    $(wildcard include/config/x86/ppro/fence.h) \
    $(wildcard include/config/x86/oostore.h) \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/cmpxchg.h \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/cmpxchg_32.h \
    $(wildcard include/config/x86/cmpxchg.h) \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/nops.h \
    $(wildcard include/config/mk7.h) \
  /usr/src/linux-headers-2.6.32-5-common/include/linux/irqflags.h \
    $(wildcard include/config/trace/irqflags.h) \
    $(wildcard include/config/irqsoff/tracer.h) \
    $(wildcard include/config/trace/irqflags/support.h) \
    $(wildcard include/config/x86.h) \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/irqflags.h \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/paravirt.h \
    $(wildcard include/config/highpte.h) \
    $(wildcard include/config/paravirt/spinlocks.h) \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/pgtable_types.h \
    $(wildcard include/config/compat/vdso.h) \
    $(wildcard include/config/proc/fs.h) \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/pgtable_32_types.h \
    $(wildcard include/config/highmem.h) \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/pgtable-2level_types.h \
  /usr/src/linux-headers-2.6.32-5-common/include/asm-generic/pgtable-nopud.h \
  /usr/src/linux-headers-2.6.32-5-common/include/asm-generic/pgtable-nopmd.h \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/paravirt_types.h \
    $(wildcard include/config/x86/local/apic.h) \
    $(wildcard include/config/paravirt/debug.h) \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/desc_defs.h \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/kmap_types.h \
    $(wildcard include/config/debug/highmem.h) \
  /usr/src/linux-headers-2.6.32-5-common/include/asm-generic/kmap_types.h \
  /users/stud16/openv/openvswitch-1.1.0pre2/datapath/linux-2.6/compat-2.6/include/linux/cpumask.h \
  /usr/src/linux-headers-2.6.32-5-common/include/linux/cpumask.h \
    $(wildcard include/config/cpumask/offstack.h) \
    $(wildcard include/config/hotplug/cpu.h) \
    $(wildcard include/config/debug/per/cpu/maps.h) \
    $(wildcard include/config/disable/obsolete/cpumask/functions.h) \
  /usr/src/linux-headers-2.6.32-5-common/include/linux/bitmap.h \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/msr.h \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/msr-index.h \
  /usr/src/linux-headers-2.6.32-5-common/include/linux/ioctl.h \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/ioctl.h \
  /usr/src/linux-headers-2.6.32-5-common/include/asm-generic/ioctl.h \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/errno.h \
  /usr/src/linux-headers-2.6.32-5-common/include/asm-generic/errno.h \
  /usr/src/linux-headers-2.6.32-5-common/include/asm-generic/errno-base.h \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/cpumask.h \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/ds.h \
    $(wildcard include/config/x86/ds.h) \
  /users/stud16/openv/openvswitch-1.1.0pre2/datapath/linux-2.6/compat-2.6/include/linux/err.h \
  /usr/src/linux-headers-2.6.32-5-common/include/linux/err.h \
  /usr/src/linux-headers-2.6.32-5-common/include/linux/personality.h \
  /usr/src/linux-headers-2.6.32-5-common/include/linux/math64.h \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/ftrace.h \
    $(wildcard include/config/function/tracer.h) \
    $(wildcard include/config/dynamic/ftrace.h) \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/atomic.h \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/atomic_32.h \
  /usr/src/linux-headers-2.6.32-5-common/include/asm-generic/atomic-long.h \
  /usr/src/linux-headers-2.6.32-5-common/include/linux/list.h \
    $(wildcard include/config/debug/list.h) \
  /usr/src/linux-headers-2.6.32-5-common/include/linux/poison.h \
    $(wildcard include/config/illegal/pointer/value.h) \
  /usr/src/linux-headers-2.6.32-5-common/include/linux/prefetch.h \
  /usr/src/linux-headers-2.6.32-5-common/include/linux/bottom_half.h \
  /usr/src/linux-headers-2.6.32-5-common/include/linux/spinlock_types.h \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/spinlock_types.h \
  /users/stud16/openv/openvswitch-1.1.0pre2/datapath/linux-2.6/compat-2.6/include/linux/lockdep.h \
    $(wildcard include/config/lockdep.h) \
    $(wildcard include/config/lock/stat.h) \
    $(wildcard include/config/generic/hardirqs.h) \
  /usr/src/linux-headers-2.6.32-5-common/include/linux/lockdep.h \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/spinlock.h \
  /usr/src/linux-headers-2.6.32-5-common/arch/x86/include/asm/rwlock.h \
  /usr/src/linux-headers-2.6.32-5-common/include/linux/spinlock_api_smp.h \

/users/stud16/openv/openvswitch-1.1.0pre2/datapath/linux-2.6/time.o: $(deps_/users/stud16/openv/openvswitch-1.1.0pre2/datapath/linux-2.6/time.o)

$(deps_/users/stud16/openv/openvswitch-1.1.0pre2/datapath/linux-2.6/time.o):
