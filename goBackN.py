import random

nf = int(input("Enter the number of frames: "))
N = int(input("Enter the Window Size: "))
no_tr = 0
i = 1

while i <= nf:
    frames_sent = list(range(i, min(i + N, nf + 1)))
    print(f"Sending Frames: {frames_sent}")

    # Simulate receiving acknowledgments for each frame individually
    ack_received = []
    for frame in frames_sent:
        ack_status = random.choice([True, False])
        ack_received.append(ack_status)
        print(f"Acknowledgment for Frame {frame}: {'Received' if ack_status else 'Not Received'}")
        no_tr += 1

    if all(ack_received):
        print("All frames acknowledged")
        i += N
    else:
        # Find the index of the first unacknowledged frame
        first_unacked_frame_index = ack_received.index(False)
        i += first_unacked_frame_index
        print(f"Retransmitting from Frame {i}")
    print()

print(f"Total number of transmissions: {no_tr}")
